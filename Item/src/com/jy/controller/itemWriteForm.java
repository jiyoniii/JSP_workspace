package com.jy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jy.itemdao.ItemDAO;
import com.jy.itemdto.itemVO;


@WebServlet("/itemWriteForm.do")
public class itemWriteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public itemWriteForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		
		//각 값을 얻어와 변수로 저장.
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		itemVO iVo=new itemVO();
		iVo.setName(name);
		iVo.setPrice(Integer.parseInt(price));
		iVo.setDescription(description);
		
		ItemDAO iDao = ItemDAO.getInstance();
		int result = iDao.insertItem(iVo);
		
		
		if(result==1) {
			iVo=iDao.getItem(name);
			HttpSession session = request.getSession();
			session.setAttribute("inputName", iVo);
			request.setAttribute("message", "등록성공");
		}else {
			request.setAttribute("message", "등록실패");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("check.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
