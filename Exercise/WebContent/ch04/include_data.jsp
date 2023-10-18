<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String a = request.getParameter("dan");
	int dan = Integer.parseInt(a);
	for(int i = 1; i<=9; i++){
		out.print(dan + " * " + i + " = " + dan*i+"<br/>");
	}
%>