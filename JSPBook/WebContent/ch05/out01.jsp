<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Object</title>
</head>
<body>
<%
	out.print("오늘의 날짜 밀 시간 : \n");
	out.println("<p>"+Calendar.getInstance().getTime()+"</p>");
	out.print("개똥이");

%>
</body>
</html>