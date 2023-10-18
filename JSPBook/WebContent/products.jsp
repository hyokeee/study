<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="vo.ProductVO"%>
<%@ page import="java.util.List"%>
<%@ page import="dao.ProductRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% //스크립틀릿
   //public ProductRepository() {생성자가 실행됨
   //기본 생성자. 3개의 상품 정보가 들어있음
   ProductRepository productDAO = ProductRepository.getInstance();

%>
<!DOCTYPE html>
<html>
<head>
<!-- 링크 렐르 흐 -->
<link rel="stylesheet" href="/css/bootstrap.min.css"/>
<title>상품 목록</title>
</head>
<body>
<!-- scope : 영역
	  토르의 활동 영역 : 대전            / 대한민국                    / 아시아                               / 지구
	 scope : page(동일 jsp) / request(동일 요청) / session(동일 웹브라우저) / application(모든웹브라우저)
	 scope객체 : pageCotext / request         / session             / application
	 ==> 해당 변수가 어느정도 영역에서까지 사용될 수 있는가, taglib c에서 디폴트 값은 scope="page"임
 -->
<% //스크립틀릿
	//SELECT * FROM PRODUCT
	List<ProductVO> listOfProducts = productDAO.getAllProducts();
	//out.print("listOfProducts :" + listOfProducts);
%>
<c:set var="listOfProducts" value="<%=listOfProducts %>" scope="page"/>
	<!-- include 액션 태그 -->
	<jsp:include page="menu.jsp" />
	
	<!-- ////////////////body 시작//////////////// -->
	<div class="jumbotron">
		<!-- container : 이 안에 내용있다. -->
		<div class="container">
			<h1 class="display-3">상품 목록</h1>
			
		</div>
	</div>
	<!-- container : 이 안에 내용있다 -->
	<div class="container">
		<!-- 행 별 처리 -->
		<div class="row" style="justify-content:right;margin:0 0 30px 0;">
			<a href="addProduct.jsp" class="btn btn-primary">상품 추가</a>
		</div>
		<div class="row" align="center">
				<!-- List<ProductVO> listOfProducts -->
				<!-- getter메서드로 접근이 가능하지만 멤버변수로도 접근 가능하다 vo.Filename / vo.getFilename() -->
			<c:forEach var="vo" items="${listOfProducts}" varStatus="stat">
			<div class="col-md-4"><!-- 열 별 처리 -->
				<img style="width : 100%; height : 200px;"src="./images/${vo.getFilename()}" alt="${vo.getPname()}" title="${vo.getPname()}" />
				<h3>${vo.getPname()}</h3>
				<p>${vo.getDescription()}</p>
				<p>${vo.getUnitPrice()}</p>
				<p><a href="product.jsp?productId=${vo.getProductId()}" class="btn btn-secondary" role="button">상세정보</a></p>
			</div>
			</c:forEach>
		</div>
	</div>
	
	<!-- ////////////////body 끝//////////////// -->
	<!-- footer -->
	<jsp:include page="footer.jsp" />
</body>
</html>