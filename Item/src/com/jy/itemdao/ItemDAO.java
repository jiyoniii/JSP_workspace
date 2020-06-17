package com.jy.itemdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jy.itemdto.itemVO;

public class ItemDAO {
	private ItemDAO() {
	}
	//instance 생성
	private static ItemDAO instance = new ItemDAO();	

	public static ItemDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception{
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	//입력한 정보를 DB에 추가하기 위한 메소드
	public int insertItem(itemVO iVo) {
		int result = -1;
		String sql ="insert into item values(?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, iVo.getName());
			pstmt.setInt(2, iVo.getPrice());
			pstmt.setString(3, iVo.getDescription());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//DB에 있는 정보를 가져오기 위한 메소드
	public itemVO getItem(String name) {
		itemVO iVo = null;
		String sql = "select * from item where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				iVo = new itemVO();
				iVo.setName(rs.getString("name"));
				iVo.setPrice(rs.getInt("price"));
				iVo.setDescription(rs.getString("description"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return iVo;
	}
	
	
	
}





