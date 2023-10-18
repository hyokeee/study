package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int first = Integer.parseInt(request.getParameter("first"));
		String sign = request.getParameter("sign");
		int second = Integer.parseInt(request.getParameter("second"));
		String result = "";
		switch(sign) {
			case "+":
				result = first + " + " + second + " = " + (first+second);
				break;
			case "-":
				result = first + " - " + second + " = " + (first-second);
				break;
			case "*":
				result = first + " * " + second + " = " + Math.round(((double)first*second)*10)/10.0;
				break;
			case "/":
				result = first + " / " + second + " = " + Math.round(((double)first/second)*10)/10.0;
				break;
			case "%":
				result = first + " % " + second + " = " + Math.round(((double)first%second)*10)/10.0;
				break;
		}
		
		//-------------------------------------------------------------------------
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'><title>Request객체 연습</title></head>");
		out.println("<body>");
		out.println("<h2>계산 결과</h2>");
		out.println("<hr><br>");
		out.println("<p>"+result+"</p>");
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
