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


@WebServlet("/insertReply.do")
public class InsertReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//전송되는 값 받기 - rdata==> bonum, cont, name
		ReplyVO rvo = new ReplyVO();
		
		try {
			BeanUtils.populate(rvo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//service 객체 호출 
		IBoardService service = BoardServiceImpl.getInstance();
		int cnt = service.insertReply(rvo);
		
		//결과값을 request에 저장
		request.setAttribute("result", cnt);
		//view페이지로 이동
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
	}

}
