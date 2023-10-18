<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="ch04.com.dao.BookVO"%>
<%@ page import="ch04.com.dao.BookRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page errorPage="exceptionNoBookId.jsp" %>
<% 
   BookRepository bookDAO = BookRepository.getInstance();
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap.min.css"/>
<title>도서 상세 정보</title>
<script>
	function addToCart(){
		if(confirm("상품을 장바구니에 추가하시겠습니까?")){
			document.addForm.submit();
		}else{
			alert("취소되었습니다.");
		}
	}
</script>
<style>
	.a{
		display : flex;
	}
</style>
</head>
<body>
	<!-- include 액션 태그 -->
	<jsp:include page="menu.jsp"/>
	
	<!-- 상품 상세 시작 -->
	<div class="jumbotron">
		<!-- container : 내용 -->
		<div class="container">
			<h1 class="display-3">도서 정보</h1>
		</div>
	</div>
<%	//스크립틀릿
	//요청URI : product.jsp?bookId=""
	//요청URL : product.jsp
	//요청파라미터 : bookId=""
	//요청방식 : get
	String bookId = request.getParameter("bookId");

	
	//SELECT * FROM BOOK WHERE BOOK_ID = 'P1234'
	BookVO book = bookDAO.getBookById(bookId);
%>	
<%--java의 변수를 JSTL 변수로 가져옴 --%>
<c:set var="book" value="<%=book %>"/>
	<!-- 내용 -->
	<div class="container">
		<!-- 1건의 상품. 1행(로우=레코드=튜플) -->
		<div class="row">
		<div class="a">
		<img style="width : auto; height : 70%; margin-right : 30px;"  src="./images/${book.fileName }" alt="${book.name}" title="${book.name}" />
			<div class="col">
				<h3>[${book.category}] ${book.name}</h3>
				<p>${book.description }</p>
				<p><b>도서코드 : </b> <span class="badge badge-danger">${book.bookId}</span></p>
				<p><b>출판사 : </b> ${book.publisher}</p>
				<p><b>저자 : </b>${book.author}</p>
				<p><b>재고수 : </b>${book.unitsInStock}</p>
				<p><b>총 페이지수 : </b>${book.totalPages}</p>
				<p><b>출판 일자 : </b>${book.releaseDate}</p>
				<h3><%=book.getUnitPrice() %></h3>
				<p>
				<form name="addForm" action="addCart.jsp?bookId=${book.bookId }" method="post">
					<a href="#" class="btn btn-secondary" onclick="addToCart()">도서 주문&raquo;</a>
					<a href="cart.jsp" class="btn btn-warning">장바구니&raquo;</a>
					<a href="books.jsp" class="btn btn-secondary">도서 목록&raquo;</a>
				</form>
				</p>
			</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>