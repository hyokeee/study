<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Directives Tag</title>
</head>
<body>
<!-- var : JSTL변수
	 value : 값
	 scope : 활용범위(page(동일 jsp)/request(동일 요청)/
	 			session(동일 웹브라우저)/application(모든 웹브라우저)
 -->
<%
	//java의 변수  jsp변수와 변수명이 같아도 다른 것임
	String memId = "java변수";	
%>
<!-- jstl의 변수 -->
<c:set var="memId" value="jstl변수" scope="page" />
<p>${memId}</p>
<p><%=memId %></p>
</body>

</html>