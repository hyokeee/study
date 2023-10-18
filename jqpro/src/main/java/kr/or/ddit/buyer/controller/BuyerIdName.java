package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * Servlet implementation class BuyerIdName
 */
@WebServlet("/buyerIdName.do")
public class BuyerIdName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerIdName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전송시 데이터를 받는다
		
		//service 객체 얻는다
		IBuyerService service = BuyerServiceImpl.getInstance();
		//service 메서드 호출 - 수행결과를 얻는다
		List<BuyerVO> list = service.getAllBuyer();
		//request객체로 결과를 저장한다
		request.setAttribute("buyerList", list);
		
		//view페이지로 이동 - 수행결과로 응답데이터를 생성 - json배열
		request.getRequestDispatcher("/0526/idname.jsp").forward(request, response);
		
	}

}
