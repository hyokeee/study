<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isErrorPage="true"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<title>서비스 문제 발생</title>
</head>
<body>
	<!-- /images : WebContent > images 폴더 -->
	<img style="width : 100%; height : 100%" src="/images/error2.png"/>
	<br/>
	<%
		//exception 내장 객체
		exception.printStackTrace(new PrintWriter(out));
	%>
	
</body>
</html>