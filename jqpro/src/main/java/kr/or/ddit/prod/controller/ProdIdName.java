package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.Service.IProdService;
import kr.or.ddit.prod.Service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdIdName
 */
@WebServlet("/prodIdName.do")
public class ProdIdName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdIdName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송요청시 전달 데이터 받기 - lgu
		String lgu = request.getParameter("lgu");
		// service객체 얻기
		IProdService service = ProdServiceImpl.getInstance();
		// service 메서드 호출 - 결과값 가져오지
		List<ProdVO> pListByLgu = service.getProdsByLprodGu(lgu);
		// 결과값 request에 저장
		request.setAttribute("pListByLgu", pListByLgu);
		// view페이지로 이동하기
		request.getRequestDispatcher("/0530/prodsBylgu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
