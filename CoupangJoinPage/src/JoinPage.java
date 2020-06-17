

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinPage.do")
public class JoinPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String email=request.getParameter("email");
		String pw = request.getParameter("pw");
		String pwcheck = request.getParameter("pwcheck");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		PrintWriter out =response.getWriter();
		
		out.print("<html><body>");
		out.println("<h1>회원가입 정보</h1>");
		out.println("email : ");
		out.println(email);
		out.println("<br>비밀번호 :");
		out.println(pw);
		out.println("<br>비밀번호 체크 : ");
		out.println(pwcheck);
		out.println("<br>이름 : ");
		out.println(name);
		out.println("<br>핸드폰번호 : ");
		out.println(phone);
	
		out.print("</body></html>");
		out.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
