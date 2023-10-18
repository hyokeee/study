package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMyMemberService;
import kr.or.ddit.member.service.MyMemberServiceImpl;
import kr.or.ddit.member.vo.MyMemberVO;


@WebServlet("/detail.do")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("id");
		IMyMemberService service = MyMemberServiceImpl.getInstance();
		MyMemberVO memVo = new MyMemberVO();
		memVo = service.getMyMember(memId);
		request.setAttribute("memVo", memVo);
		request.getRequestDispatcher("/mymember/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
