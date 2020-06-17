package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/_BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파라미터인 command를 만들어 명령어를 전달.
		//파라미터에(command)에 명령어 정보를 담아 전달하고, 각 명령어에 따른 로직을 처리하는 코드를 별도의 클래스로 작성하는걸 command패턴이라고 함.
		//url에는 이렇게 넘어가게됨. >>> url 주소 + ?command=board_list
		String command = request.getParameter("command");
		System.out.println("BoardServlet에서 요청받음을 확인 : "+command);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request,response);
	}

}
