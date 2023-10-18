<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="ch04.com.dao.BookRepository"%>
<%@ page import="ch04.com.dao.BookVO"%>
<%@ page import="java.util.ArrayList"%>

<% //스크립틀릿
   //public ProductRepository() {생성자가 실행됨
   //기본 생성자. 3개의 상품 정보가 들어있음
   BookRepository bookDAO = BookRepository.getInstance();

%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<style>
.a{
	display : flex;
}

.pp{
	padding : 45px;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<body>
<!-- ///////////////////////////////header 시작(menu.jsp)////////////////////////////// -->
<%@ include file="menu.jsp"%>
<!-- ///////////////////////////////header 끝////////////////////////////// -->
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">
			도서 목록
		</h1>
	</div>
</div>
<% 
ArrayList<BookVO> listOfBooks = bookDAO.getAllBooks();

%>
<div class="container">
	<div class="row" style="justify-content:right;margin:0 0 30px 0;">
		<a href="addBook.jsp" class="btn btn-primary">도서 추가</a>
	</div>
	
<%
    	for(int i=0;i<listOfBooks.size();i++){
    		BookVO book = listOfBooks.get(i);
 %>
 	<div class="row" align="left">
		<div class="col-md-10">
			<div class="a">
   	    	<img style="width : 150px; height : 180px;"  src="./images/<%=book.getFileName()%>" alt="<%=book.getName() %>" title="<%=book.getName()%>" />
   	    	<div class="col-lg">
    			<h4>[<%=book.getCategory() %>] <%=book.getName() %></h4>
    			<p><%=book.getDescription()%></p>
   				<p><%=book.getAuthor() %>|<%=book.getPublisher() %>|<%=book.getUnitPrice() %></p>
   			</div>
   			<p class="pp"><a href="book.jsp?bookId=<%=book.getBookId() %>" class="btn btn-secondary" role="button">상세정보</a></p>
    		  
    		</div>
    	</div>  
    		
    
    </div> 
    <hr/>
    <br>
<%
    	}
%>        
	
</div>
<!-- /////////////////////////footer시작(footer.jsp)/////////////////////// -->
<%@ include file="./footer.jsp" %>
<!-- /////////////////////////footer 끝/////////////////////// -->
</body>
</html>