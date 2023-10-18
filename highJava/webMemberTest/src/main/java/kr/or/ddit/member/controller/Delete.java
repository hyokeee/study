package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMyMemberService;
import kr.or.ddit.member.service.MyMemberServiceImpl;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/delete.do")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		int cnt = 0;
		
		IMyMemberService service = MyMemberServiceImpl.getInstance();
		cnt = service.deleteMyMember(id);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(cnt>0) {
			out.println("<html><head><meta charset='utf-8'></head>");
			out.println("<body><h1>회원 정보가 삭제되었습니다.</h1><a href='"+request.getContextPath()+"/memberList.do'>회원 목록 보기</a></body></html>");
		}else {
			out.println("<html><head><meta charset='utf-8'></head>");
			out.println("<body><h1>회원 정보삭제를 실패했습니다.</h1><a href='"+request.getContextPath()+"/memberList.do'>회원 목록 보기</a></body></html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
