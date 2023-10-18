<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%
	Calendar c = Calendar.getInstance();
	out.print("현재 시간 : " + c.getTime());
%>
</body>
</html>