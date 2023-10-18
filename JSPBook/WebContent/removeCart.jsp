<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="vo.ProductVO"%>
<%@ page import="dao.ProductRepository"%>
<%	//스크립틀릿
	//http://localhost/removeCart.jsp?productId=P1235
	//요청파라미터(productId=P1235)를 받아서 변수에 저장
	String productId = request.getParameter("productId");	//P1235
	
	//만약에 removeCart.jsp 또는 removeCart.jsp?productId=P0000
	// productId : null
	if(productId == null || productId.trim().equals("")){
		response.sendRedirect("products.jsp");
		return;
	}
	
	//상품검색메서드 호출(select * from product where product_id = 'P1235')
	//상품저장소 클래스 => 싱글톤 객체 생성(메모리에 1회 생성. 공유해서 사용)
	ProductRepository dao = ProductRepository.getInstance();
	ProductVO productVO = dao.getProductById(productId);
	if(productVO ==null){	//상품 검증 실패, 해당 상품 없음
		response.sendRedirect("exceptionNoProductId.jsp");
		return;
	}
	
	//세션의 장바구니(세션) 목록에서 P1234 상품이 있는지 체크한 후
	// 만약에 있다면 장바구니에서 제외처리
	//session.setAttribute("cartlist",list)
	List<ProductVO> cartlist = (List<ProductVO>) session.getAttribute("cartlist");
	
	for(int i=0; i<cartlist.size(); i++){
		//파라미터를 받은 변수(productId)- 삭제 할 대상.(P1235)
		//"P1235".equals("P1235") -> 해당 삭제할 대상 상품이 장바구니에 있다면
		if(productId.equals(cartlist.get(i).getProductId())){
			//remove(Object)
			cartlist.remove(cartlist.get(i));	//삭제 성공
			
		}
	}
	
	response.sendRedirect("cart.jsp");
%>