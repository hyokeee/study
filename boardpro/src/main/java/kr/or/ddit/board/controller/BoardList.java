package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.reflection.SystemMetaObject;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardList.do")
public class BoardList extends HttpServlet {
   private static final long serialVersionUID = 1L;


   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      //1. 요청시 전송데이타 받기 - 페이지 번호 검색시 stype, sword
      int page = Integer.parseInt(request.getParameter("page"));
      // page = 최초 시행시 무조건 1
      String stype = request.getParameter("stype");
      String sword = request.getParameter("sword");
      //stype, sword는 최소 실행시 값은 null
      
      //2. service객체 얻기
      IBoardService service = BoardServiceImpl.getInstance();
      // listPerPage를 호출하기 위한 준비 작업
      PageVO pvo = service.pageInfo(page, stype, sword);
      //3. service메소드 ListPerpage 호출하기 - 결과값 받기
      Map<String, Object> map = new HashMap<>();
      map.put("start", pvo.getStart());
      map.put("end", pvo.getEnd());
      map.put("stype", stype);
      map.put("sword", sword);
      
      List<BoardVO> list = service.listPerPage(map);
      //4. 결과값 request에 저장 하기
      request.setAttribute("list", list);
      request.setAttribute("vo", pvo);
      //5. view페이지로 이동
      request.getRequestDispatcher("/view/list.jsp").forward(request, response);
   }

}