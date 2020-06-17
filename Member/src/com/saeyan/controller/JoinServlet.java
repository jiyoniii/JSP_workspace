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

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join.jsp");
		dispatcher.forward(request, response);
	
	}

	//폼에서 입력한 값들을 DB에 입력하는 코드.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//회원가입 폼에 입력한 내용들을 가져오는 코드.
		String name = request.getParameter("name");  //name으로 가져온걸 String name으로 저장.
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		//회원정보를 저장 할 객체를 생성함.
		MemberVO mVo = new MemberVO();
		
		//위에서 회원가입폼에서 입력 한 내용들을 가져오고,
		//여기에서는 mVo에 그 내용들을 하나씩 저장하게 됨.
		mVo.setName(name); //위에 String name으로 저장했으니, 이걸 setName으로 가져옴.
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAdmin(Integer.parseInt(admin));
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMember(mVo);
		HttpSession session = request.getSession();
		if (result == 1) {
			session.setAttribute("userid", mVo.getUserid());
			request.setAttribute("message", "회원 가입에 성공했습니다.");
		} else {
			request.setAttribute("message", "회원 가입에 실패했습니다.");
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
	}

}
