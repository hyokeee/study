package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;


@WebServlet("/checkMemberId.do")
public class CheckMemberId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 전송데이터 받기
		String memId = request.getParameter("checkid");
		//service 객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		//service 메서드 호출
		String check = null;
		check = service.checkMemberId(memId);
		//결과값을 request에 저장
		if(check!=null) {
			request.setAttribute("check", "이미 존재하는 아이디");
		} else {
			request.setAttribute("check", "사용 가능한 아이디");
		}
		//view 페이지로 이동 - json데이터 생성
		request.getRequestDispatcher("/0601/checkid.jsp").forward(request, response);
	}

}
