package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;


@WebServlet("/replyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		List<ReplyVO> rList = null;
		IBoardService service = BoardServiceImpl.getInstance();
		rList = service.listReply(bonum);
		
		request.setAttribute("rList", rList);
		request.getRequestDispatcher("/view/replyList.jsp").forward(request, response);
		
	}

}
