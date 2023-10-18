<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 더 멋진 석일</title>
</head>
<body>
	<h1>구두가 뽀인토</h1>
	<form action="<%=request.getContextPath()%>/login" method="post">
		아이딩<input type="text" name="username" value=""><br>
		암호호<input type="password" name="password" value=""><br>
		<button type="submit" >로그인</button>
		<sec:csrfInput/>
	</form>
	
	<h1>manual login 어쩌다 필요</h1>
	<form action="/mylogin" method="post">
		<sec:csrfInput/>
		아이디2<input type="text" name="myname" value=""><br>
		암호222<input type="password" name="mypass" value=""><br>
		<button type="submit">로그인2</button>
	</form>
</body>
</html>