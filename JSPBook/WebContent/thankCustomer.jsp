<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<title>주문완료</title>
</head>
<body>
<%	//스크립틀릿
String Shipping_cartId       = "";
String Shipping_name         = "";
String Shipping_shippingDate = "";
String Shipping_country      = "";
String Shipping_zipCode      = "";
String Shipping_addressName  = "";

Cookie[] cookies = request.getCookies();
// 쿠키 개수만큼 반복
for(int i=0; i<cookies.length; i++){
	  Cookie thisCookie = cookies[i];
	  if(thisCookie.getName().equals("shipping_name")){
		  Shipping_name = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
	  }
	  if(thisCookie.getName().equals("shipping_shippingDate")){
		  Shipping_shippingDate = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
	  }
	  if(thisCookie.getName().equals("shipping_country")){
		  Shipping_country = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
	  }
	  if(thisCookie.getName().equals("shipping_zipCode")){
		  Shipping_zipCode = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
	  }
	  if(thisCookie.getName().equals("shipping_addressName")){
		  Shipping_addressName = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
	  }
	  if(thisCookie.getName().equals("shipping_cartId")){
		  Shipping_cartId = URLDecoder.decode(thisCookie.getValue(),"UTF-8");
	  }
}

%>
	<!-- ///////////////////////////////header 시작(menu.jsp)////////////////////////////// -->
	<%@ include file="./menu.jsp"%>
	<!-- ///////////////////////////////header 끝////////////////////////////// -->

	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문완료</h1>
		</div>
	</div>
	<div class="container">
	<!-- /////////////////////////주문 완료 내용 시작//////////////////////////////// -->
		<h2 class="alert alert-danger">주문해주셔서 감사합니다.</h2>
		<p>주문은 <%=Shipping_shippingDate %>에 배송될 예정입니다.</p>
		<p>주문번호 : <%=Shipping_cartId %></p>
	<!-- /////////////////////////주문 완료 내용 끝//////////////////////////////// -->
	</div>
	<div class="container">
		<p><a href="products.jsp" class="btn btn-secondary">&raquo;상품 목록</a></p>
	</div>
	<!-- /////////////////////////footer시작(footer.jsp)/////////////////////// -->
	<%@ include file="footer.jsp" %>
	<!-- /////////////////////////footer 끝/////////////////////// -->
<%
//1) 장바구니 비우기
	session.removeAttribute("cartlist");
//2) 쿠키 비우기
//Cookie[] cookies
	for(int i = 0; i<cookies.length; i++){
		Cookie thisCookie = cookies[i];
		if(thisCookie.getName().equals("shipping_name")){
			thisCookie.setMaxAge(0);
		}
		if(thisCookie.getName().equals("shipping_shippingDate")){
			thisCookie.setMaxAge(0);
		}
		if(thisCookie.getName().equals("shipping_country")){
			thisCookie.setMaxAge(0);
		}
		if(thisCookie.getName().equals("shipping_zipCode")){
			thisCookie.setMaxAge(0);
		}
		if(thisCookie.getName().equals("shipping_addressName")){
			thisCookie.setMaxAge(0);
		}
		if(thisCookie.getName().equals("shipping_cartId")){
			thisCookie.setMaxAge(0);
		}		
		response.addCookie(thisCookie);
	}
%>
</body>
</html>