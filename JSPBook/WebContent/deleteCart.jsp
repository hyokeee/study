<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%	//스크립틀릿
	// /deleteCart.jsp?cartId=D6DE9C9B6598F164DEDB6BE1DC27853F
	// 요청파라미터 : cartId =D6DE9C9B6598F164DEDB6BE1DC27853F
	// session.getId() = 세션고유아이디 = 고유장바구니 = 동일웹브라우저 = 1명의고객
	String cartId
		= request.getParameter("cartId");//D6DE9C9B6598F164DEDB6BE1DC27853F
	//cartId가 없네 ? => cart.jsp로 이동
	if(cartId==null||cartId.trim().equals("")){
		response.sendRedirect("cart.jsp");
		return;
	}
	
	//장바구니만 비우자
	session.removeAttribute("cartlist");	//장바구니만 콕 찝어서 삭제
	//만약 session.invalidate() ==> 로그아웃도 되어버림
	
	//cart.jsp
	response.sendRedirect("cart.jsp");
%>
