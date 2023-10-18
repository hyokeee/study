<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="vo.ProductVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<title>장바구니</title>
</head>
<body>
	<!-- include 액션 태그 -->
	<jsp:include page="menu.jsp"/>
	
	<!-- 장바구니 시작 -->
	<div class="jumbotron">
		<!-- container : 이 안에 내용있다 -->
		<div class="container">
			<h1 class="display-3">장바구니</h1>
		</div>
	</div>
<%	//스크립틀릿
	//ArrayList<ProductVO> list
	//addCart.jsp의 cartlist라는 세션 속성명에 list를 매핑
	//session.setAttribute("cartlist",list);
	List<ProductVO> cartList = (List<ProductVO>) session.getAttribute("cartlist");
	
	//세션의 고유 아이디(장바구니 번호)
	String cartId = session.getId();
	
%>
	<c:set var="cartList" value="<%=cartList %>"/>
	<c:set var="cartId" value="<%=cartId %>"/>
	<!-- 장바구니 상세 내역 시작 -->
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
		<!-- padding-top : 영역의 위쪽 여백을 50픽셀로 줌 -->
		<div style="padding-top:50px;">
			<table class="table table-hover">
				<tr>
					<th>상품</th><th>가격</th><th>수량</th>
					<th>금액</th><th>비고</th>
				</tr>
	<!-- 장바구니가 비어있다면 -->
	<c:if test="${cartList==null || cartList.size()==0}">
				<tr style="text-align:center;">
					<td colspan="5">
						<p>장바구니가 비어있습니다.</p>					
					</td>
				</tr>
	</c:if>
	<!-- 장바구니에 상품목록이 있다면... -->
	<c:if test="${cartList!=null && cartList.size() != 0 }">
				<!-- List<ProductVO> cartList -->
				<c:forEach var="productVO" items="${cartList}" varStatus="stat">
					<!-- 금액 : 가격 x 수량 -->
					<c:set var="amount" value="${productVO.quantity * productVO.unitPrice}" />
					<!-- total = total + amount -->
					<c:set var="total" value="${total+amount }"/>
				<tr>
					<td>${productVO.productId}-${productVO.pname}</td>
					<td>${productVO.unitPrice}</td>
					<td>${productVO.quantity}</td>
					<td>${amount}</td>
					<td>
					<a href="removeCart.jsp?productId=${productVO.productId }"
						class="badge badge-danger">삭제</a>
					</td>
				</tr>
				</c:forEach>
				<tr>
					<th></th><th></th><th>총액</th>
					<th>${total }</th><th></th>
				</tr>
	</c:if>
			</table>
			<a href="products.jsp" class="btn btn-secondary">&laquo;쇼핑 계속하기</a>
		</div>
	</div>
	<!-- 장바구니 상세 내역 끝 -->
	<jsp:include page="footer.jsp"/>
</body>
</html>