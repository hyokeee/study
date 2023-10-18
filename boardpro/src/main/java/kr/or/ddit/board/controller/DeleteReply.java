package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class DeleteReply
 */
@WebServlet("/deleteReply.do")
public class DeleteReply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		int renum = Integer.parseInt(request.getParameter("renum"));
		IBoardService service = BoardServiceImpl.getInstance();
		int cnt = service.deleteReply(renum);
		request.setAttribute("result", cnt);
		//view페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
	}

	

}
