<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="ch04.com.dao.BookVO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<title>장바구니</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">장바구니</h1>
		</div>
	</div>
<%
	List<BookVO> cartList = (List<BookVO>) session.getAttribute("cartlist");
	String cartId = session.getId();
	
%>
	<c:set var="cartList" value="<%=cartList %>"/>
	<c:set var="cartId" value="<%=cartId %>"/>
	
	<div class="container">
		<div class="row">
			<table width="100%;">
				<tr>
					<td align="left">
						<a href="deleteCart.jsp?cartId=${cartId }"
							class="btn btn-danger">삭제하기</a>
					</td>
					<td align="right">
						<a href="shippingInfo.jsp?cartId=${cartId }"
							class="btn btn-success">주문하기</a>
					</td>
				</tr>
			</table>
		</div>
		<div style="padding-top:50px;">
			<table class="table table-hover">
				<tr>
					<th>도서</th><th>가격</th><th>수량</th>
					<th>금액</th><th>비고</th>
				</tr>
		<c:if test="${cartList==null || cartList.size() ==0 }">
				<tr style="text-align:center;">
					<td colspan="5">
						<p>장바구니가 비어있습니다.</p>					
					</td>
				</tr>
		</c:if>
		<c:if test="${cartList!=null && cartList.size() !=0 }">
			<c:forEach var="bookVO" items="${cartList }" varStatus="stat">
				<c:set var="amount"  value="${bookVO.quantity * bookVO.unitPrice }"/>
				<c:set var="total"  value="${total + amount }"/>
				<tr>
					<td>${bookVO.bookId }-${bookVO.name }</td>
					<td>${bookVO.unitPrice }</td>
					<td>${bookVO.quantity }</td>
					<td>${amount }</td>
					<td>
						<a href="removeCart.jsp?bookId=${bookVO.bookId }"
							class = "badge badge-danger">삭제</a>
					</td>
				</tr>
			</c:forEach>
				<tr>
					<th></th><th></th><th>총액</th>
					<th>${total }</th><th></th>
				</tr>
		</c:if>
			</table>
			<a href="books.jsp" class="btn btn-secondary">&laquo;쇼핑 계속하기</a>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>