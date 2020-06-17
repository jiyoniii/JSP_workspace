package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url ="member/login.jsp";
    	
    	HttpSession session = request.getSession();
    	
    	//회원정보 변경 후 다시 로그인을 할 필요 없이 바로 메인페이지로 이동하기 위한 코드
    	
    	if(session.getAttribute("loginUser") != null) { //이미 로그인된 사용자라면 loginUser의 세션 값으로 판단
    		url="main.jsp"; //메인페이지로 이동한다.
    	}
    	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
    	
    	dispatcher.forward(request, response);
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(userid, pwd);
		
		if(result ==1) {
			MemberVO mVo = mDao.getMember(userid);
			//로그인하면서 얻어온 회원정보를 session에 저장해두고 어느 페이지에서든 사용 가능하도록.
			HttpSession session = request.getSession();
			//여기서 만든 "loginUser"를 사용해서 이사람의 userid, pw,email등등을 한번에 넘길 수 있음.
			session.setAttribute("loginUser", mVo);
			
			//아래 문구는 로그인페이지 {message}에 "회원가입에 성공했습니다."로 출력이 됨.
			request.setAttribute("message", "회원가입에 성공했습니다.");
			url ="main.jsp"; //로그인에 성공하면 main.jsp로 이동
			
		}else if(result ==0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result ==-1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
