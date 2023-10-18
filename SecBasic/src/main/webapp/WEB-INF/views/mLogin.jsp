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
<h1>이거슨 M Login 페이징</h1>
<form action="/sec/angma/login" method="post">
	ID<input type="text" name="username" value=""><br>
	PASSWORD<input type="password" name="password" value=""><br>
	<input type="submit" value="Login">
	<sec:csrfInput/>
</form>

</body>
</html>