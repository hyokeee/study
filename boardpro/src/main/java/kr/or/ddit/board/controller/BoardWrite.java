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
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/boardWrite.do")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 요청시 전송데이터 받기 -fdata - writer,subject,mail,password,content
		BoardVO bvo = new BoardVO();
		try {
			BeanUtils.populate(bvo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// service 객체 생성
		IBoardService service = BoardServiceImpl.getInstance();
		bvo.setWip(request.getRemoteAddr());
		// service 메서드 호출 - > 결과값( 1 or 0 )
		int cnt = service.insertBoard(bvo);
		// request결과값 저장
		request.setAttribute("result", cnt);
		// view 페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
		
	
	}

}
