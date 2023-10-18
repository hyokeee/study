<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="ch04.com.dao.BookVO"%>
<%@ page import="ch04.com.dao.BookRepository"%>
<%
	String bookId = request.getParameter("bookId");

	out.print("bookId : "  + bookId);
	
	if(bookId == null||bookId.trim().equals("")){
		response.sendRedirect("books.jsp");
		return;
	}
	
	BookRepository dao = BookRepository.getInstance();
	BookVO book = dao.getBookById(bookId);
	
	if(book==null){
		response.sendRedirect("exceptionNoBookId.jsp");
	}
	
	ArrayList<BookVO> list
		= (ArrayList<BookVO>) session.getAttribute("cartlist");
	
	if(list ==null|| list.size()==0){
		list = new ArrayList<BookVO>();
		session.setAttribute("cartlist", list);
	}
	int cnt = 0;
	for(int i = 0 ; i<list.size(); i++){
		if(bookId.equals(list.get(i).getBookId())){
			cnt++;
			list.get(i).setQuantity(list.get(i).getQuantity()+1);
		}
	}
	
	if(cnt==0){
		book.setQuantity(1);
		list.add(list.size(),book);
	}
	
	for(BookVO vo : list){
		out.print("vo : " + vo + "<br/><hr/>");
	}
	response.sendRedirect("book.jsp?bookId="+bookId);

%>