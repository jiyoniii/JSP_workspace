package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.saeyan.dto.MemberVO;

//싱글톤 패턴으로 작성된 DAO. 싱글톤은 오로지 한개의 instance로만 작성되어야 함.
public class MemberDAO {
	//생성자
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		//MemberDAO 객체를 리턴하게 됨
		return instance;
	}
	
	
	//throw Exception은 try/catch 대신 약식으로 처리하는 방법.
	public Connection getConnection() throws Exception{
		
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();

		return conn;
	}
	
	//사용자 인증 시 사용하는 메소드
	public int userCheck(String userid, String pwd) {
		int result = -1; //초기값에 -1을 먼저 줘서 일치하는 회원이 없는것으로 가정하고 시작.
		String sql = "select pwd from member where userid=?"; //로그인시 임력한 userid로 검색해서 pwd를 가져옴
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid); //sql문의 ?에 매개변수로 받아온 아이디를 바인딩 시킴.
			rs = pstmt.executeQuery(); //쿼리문 실행한 결과값을 rs에 저장.
			if(rs.next()) { //rs가 일치하는 행이 존재하면 rs.next()는 true임.
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)) { //DB에서 가져온 pwd가 null값이 아니고, pwd가 일치한다면
					result = 1; //id가 존재하는게 true이면 pwd도 확인. pwd까지 일치하면 result는 1일 되는것임.
				}else {
					result = 0; //id는 일치하지만 pwd가 불일치 하면 0
				}
			}else {	//어느것도 일치하지 않음 -1
				result = -1;
			}
		}catch(Exception e)	{
			e.printStackTrace();
		}finally { //접속한 DB끊어주는 역할
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	
	//아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember (String userid) { 
		MemberVO mVo = null;
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return mVo;
	}
	
	
	//아이디 중복체크 ( DB에 존재하는 아이디인지를 점검하기 위한 메소드 추가)
	
	public int confirmID(String userid) {
		int result = -1;
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//회원정보를 DB에 추가하기 위한 메소드 추가하기
	public int insertMember(MemberVO mVo) {
		int result = -1;
		String sql = "insert into member values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			//VO에서 가져온 객체
			pstmt.setString(1, mVo.getName());
			pstmt.setString(2, mVo.getUserid());
			pstmt.setString(3, mVo.getPwd());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getPhone());
			pstmt.setInt(6, mVo.getAdmin());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null)pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//회원정보 업데이트 위한 메소드 추가
	public int updateMember(MemberVO mVo) {
		int result = -1;
		String sql = "update member set pwd=?, email=?,"
				+ "phone=?, admin=? where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getPwd());
			pstmt.setString(2, mVo.getEmail());
			pstmt.setString(3, mVo.getPhone());
			pstmt.setInt(4, mVo.getAdmin());
			pstmt.setString(5, mVo.getUserid());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
}
