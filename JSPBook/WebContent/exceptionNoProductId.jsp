<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- /product.jsp?productId=P0000 -->
<title>상품 아이디 오류</title>
</head>
<body>
	<!-- ///////////////////////////////header 시작(menu.jsp)////////////////////////////// -->
	<%@ include file="./menu.jsp"%>
	<!-- ///////////////////////////////header 끝////////////////////////////// -->
	<div class="jumbotron">
		<div class="container">
			<h2 class="display-3">해당 상품이 존재하지 않습니다.</h2>
		</div>
	</div>
	<div class="container">
		<!-- .getRequestURI() : http://localhost/product.jsp 
			 .getQueryString() : productId=P0000
		-->
		<p><%=request.getRequestURI() %>?<%=request.getQueryString() %></p>
		<p><a href="products.jsp" class="btn btn-secondary">상품 목록&raquo;</a></p>
	</div>
	<!-- /////////////////////////footer시작(footer.jsp)/////////////////////// -->
	<%@ include file="footer.jsp" %>
	<!-- /////////////////////////footer 끝/////////////////////// -->
</body>
</html>