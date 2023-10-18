<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String cartId
		= request.getParameter("cartId");

	if(cartId==null||cartId.trim().equals("")){
		response.sendRedirect("cart.jsp");
		return;
	}
	
	session.removeAttribute("cartlist");
	response.sendRedirect("cart.jsp");


%>