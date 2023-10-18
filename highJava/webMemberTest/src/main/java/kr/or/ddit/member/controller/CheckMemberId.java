 package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMyMemberService;
import kr.or.ddit.member.service.MyMemberServiceImpl;


@WebServlet("/checkMemberId.do")
public class CheckMemberId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("checkid");
		
		IMyMemberService service = MyMemberServiceImpl.getInstance();
		
		int cnt = 0;
		cnt = service.isExistID(memId);
		if(cnt!=0) {
			request.setAttribute("check", "이미 존재하는 아이디입니다.");
		} else {
			request.setAttribute("check", "사용 가능한 아이디입니다.");	
		}
		request.getRequestDispatcher("/mymember/checkid.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
