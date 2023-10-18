package kr.or.ddit.buyer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * Servlet implementation class BuyerDetail
 */
@WebServlet("/buyerDetail.do")
public class BuyerDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송시 데이터를 받는다
		String id = request.getParameter("id");
		
		//service 객체 얻기
		IBuyerService service = BuyerServiceImpl.getInstance();
		//service 메서드 호출하기 - 결과값 받기
		BuyerVO buyerVo = service.selectBuyer(id);
		//결과값을 request에 저장하기
		request.setAttribute("buyerVo", buyerVo);
		//view페이지로 이동 - json데이터 만들기
		request.getRequestDispatcher("/0526/detail.jsp").forward(request, response);
	}

	
}
