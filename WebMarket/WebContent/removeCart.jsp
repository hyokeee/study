<%@page import="java.util.List"%>
<%@ page import="ch04.com.dao.BookVO"%>
<%@ page import="ch04.com.dao.BookRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String bookId = request.getParameter("bookId");

	if(bookId == null|| bookId.trim().equals("")){
		response.sendRedirect("books.jsp");
		return;
	}
	
	BookRepository dao = BookRepository.getInstance();
	BookVO bookVO = dao.getBookById(bookId);
	if(bookVO ==null){
		response.sendRedirect("exceptionNoBookId.jsp");
		return;
	}
	
	List<BookVO> cartlist = (List<BookVO>) session.getAttribute("cartlist");
	
	for(int i=0; i<cartlist.size();i++){
		if(bookId.equals(cartlist.get(i).getBookId())){
			cartlist.remove(cartlist.get(i));
		}
	}
	response.sendRedirect("cart.jsp");


%>