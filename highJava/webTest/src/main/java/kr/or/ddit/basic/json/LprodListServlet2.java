package kr.or.ddit.basic.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.session.LprodDaoImpl;
import kr.or.ddit.vo.LprodVO;


@WebServlet("/lprodListServlet2.do")
public class LprodListServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LprodDaoImpl dao = LprodDaoImpl.getInstance();
		
		List<LprodVO> lprodList = dao.getAllLprod();
		
		request.setAttribute("lprodList", lprodList);
		
		request.getRequestDispatcher("/basic/json/lprodList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
