<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="dao.ProductRepository"%>
<%@ page import="vo.ProductVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page errorPage="exceptionNoProductId.jsp" %>
<%
	//싱글톤 : 메모리에 객체가 1회 생성. 전역 변수처럼 어디서든 공유해서 사용가능
	ProductRepository productDAO = ProductRepository.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<!-- 링크 렐르 흐 -->
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<title>상품 상세 정보</title>
<script>
	function addToCart(){
		if(confirm("상품을 장바구니에 추가하시겠습니까?")){ //확인 클릭시 true
			//요청 URI : addCart.jsp?productId=P1234
			//<form name="addForm"...
			document.addForm.submit();
		} else{ //취소 시 false
			alert("취소되었습니다.");
		}
	}
</script>
</head>
<body>
	<!-- include 액션 태그 -->
	<jsp:include page="menu.jsp"/>
	
	<!-- 상품 상세 시작 -->
	<div class="jumbotron">
		<!-- container : 이 안에 내용있다 -->
		<div class="container">
			<h1 class="display-3">상품 정보</h1>
		</div>
	</div>
<%	//스크립틀릿
	//요청URI : product.jsp?productId=P1234
	//요청URL : product.jsp
	//요청파라미터 : productId=P1234
	//요청방식 : get
	String productId = request.getParameter("productId");//P1234
// 	out.print("productId : " + productId);
	
	//SELECT * FROM PRODUCT WHERE PRODUCT_ID = 'P1234'
	//productId 매개변수에 P1234,P1235,P1236가 할당될 경우 product객체에 정보가 존재
	//but P0000이 할당될 경우, product객체는 null이 된다.
	ProductVO product = productDAO.getProductById(productId);
// 	out.print("<p>"+product+"</p>");
%>
<%--java의 변수를 JSTL변수로 가져옴 --%>
<c:set var="product" value="<%=product %>"/>
	<!-- 내용 -->
	<div class="container">
		<!-- 1건의 상품. 1행(로우=레코드=튜플) -->
		<div class="row">
			<!-- 상품 이미지 -->
			<div class="col-md-5">
			<!-- page errorPage="exceptionNoProductId.jsp" -->
				<img src="./images/<%=product.getFilename() %>" 
						alt="${product.pname}" title="${product.pname}" style="width:100%;">
			</div>
			<!-- 6크기의 1열(컬럼=필드=속성=애트리뷰트) -->
			<div class="col">
				<h3>${product.pname}
				<a href="logout.jsp" class="btn btn-sm btn-success pull-right">logout</a>
				</h3>
				<p>${product.description }</p>
				<p>
					<b>상품 코드:</b>
					<span class="badge badge-danger">
						${product.productId }
					</span>
				</p>
				<p><b>제조사 : </b>${product.manufacturer }</p>
				<p><b>분류 : </b>${product.category }</p>
				<p><b>재고 수 : </b>${product.unitsInStock }</p>
				<p>
				<form name= "addForm" action= "addCart.jsp?productId=${product.productId}" method="post">
					<!-- addToCart() : 핸들러함수 -->
					<a href="#" class="btn btn-info" onclick="addToCart()">상품주문&raquo;</a>
					<a href="cart.jsp" class="btn btn-warning">장바구니&raquo;</a>
					<a href="products.jsp" class="btn btn-secondary">상품 목록&raquo;</a>
				</form>
				</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>