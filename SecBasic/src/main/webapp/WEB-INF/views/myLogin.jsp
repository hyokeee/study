<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WelCome Please Login</h1>
<form action="/sec/login" method="post">
	ID<input type="text" name="username" value=""><br>
	PASSWORD<input type="password" name="password" value=""><br>
	<input type="submit" value="Login">
	<sec:csrfInput/>
</form>
<h1>Good Bye Logout</h1>
<form action="/sec/logout" method="post">
	<sec:csrfInput/>
	<input type="submit" value="Logout">
</form>
</body>
</html>