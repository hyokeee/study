package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirectTest.do")
public class RedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("username");	//파라미터 데이터를 받을 수 있다.
		//String tel = (String)request.getAttribute("tel");	//setAttribute()메서드로 보낸 데이터 받기
		String tel = request.getParameter("tel");	//redirect방식에서 데이터를 전송하고자 GET방식으로 주솟값 뒤에 값을 넣은 경우, Parameter로 받아야 한다. 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf=8'><title>redirect연습</title></head>");
		out.println("<body>");
		
		out.println("<h2>Redirect 방식 결과</h2><hr>");
		
		out.println("<table border='1'>");
		out.println("<tr><td>이 름</td>");
		out.println("<td>"+userName+"</td></tr>");
		
		out.println("<tr><td>전 화</td>");
		out.println("<td>"+ tel +"</td></tr>");
		out.println("</table>");
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
