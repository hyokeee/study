<%@page import="ch04.com.dao.BookRepository"%>
<%@page import="ch04.com.dao.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
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
BookRepository b = new BookRepository();
ArrayList<BookVO> listOfBooks = b.getAllBooks();

%>
<div class="container">
	<div class="col" align="left">
<%
    	for(int i=0;i<listOfBooks.size();i++){
    		BookVO book = listOfBooks.get(i);
 %>
   	    <div class="col-lg">
    		<h4>[<%=book.getCategory() %>]</h4>
    		<p><%=book.getDescription()%></p>
   			<p><%=book.getAuthor() %>|<%=book.getPublisher() %>|<%=book.getUnitPrice() %></p>
   		</div>
    	<hr>
<%
    	}
%>            
    </div> 
</div>
<!-- /////////////////////////footer시작(footer.jsp)/////////////////////// -->
<%@ include file="../ch03/footer.jsp" %>
<!-- /////////////////////////footer 끝/////////////////////// -->
</body>
</html>