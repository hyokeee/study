package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class UpdateReply
 */
@WebServlet("/updateReply.do")
public class UpdateReply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송데이터 받기 - cont, renum
		ReplyVO rvo = new ReplyVO();
		
		try {
			BeanUtils.populate(rvo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//service 객체 얻기 
		IBoardService service = BoardServiceImpl.getInstance();
		
		int cnt = service.updateReply(rvo);
		
		request.setAttribute("result", cnt);
		
		request.getRequestDispatcher("view/result.jsp").forward(request, response);
	}

}
