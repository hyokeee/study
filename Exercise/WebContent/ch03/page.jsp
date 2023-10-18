<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	Date date = new Date();
	double a = Math.pow(5, 2);
%>
</body>
현재 날짜 : <%=date %><br/>
5의 제곱 : <%=a %>
</html>