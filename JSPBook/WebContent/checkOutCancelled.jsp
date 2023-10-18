<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<title>주문취소</title>
</head>
<body>
	<!-- ///////////////////////////////header 시작(menu.jsp)////////////////////////////// -->
	<%@ include file="./menu.jsp"%>
	<!-- ///////////////////////////////header 끝////////////////////////////// -->

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문취소</h1>
		</div>
	</div>
	<%
	session.removeAttribute("cartlist");
	%>
	<div class="container">
	<!-- /////////////////////////주문 완료 내용 시작//////////////////////////////// -->
		<h1 class="alert alert-danger">주문이 취소되었습니다.</h1>
	<!-- /////////////////////////주문 완료 내용 끝//////////////////////////////// -->
	</div>
	<div class="container">
		<p><a href="products.jsp" class="btn btn-secondary">&raquo;상품 목록</a></p>
	</div>
	<!-- /////////////////////////footer시작(footer.jsp)/////////////////////// -->
	<%@ include file="footer.jsp" %>
	<!-- /////////////////////////footer 끝/////////////////////// -->

</body>
</html>