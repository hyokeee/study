<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Security</title>
</head>
<body>
	<!--
	web.xml의 <auth-method>BASIC</auth-method>를 대신하는 사용자정의 로그인 화면
	j_security_check : 요청지가 이미 있음 
	j_username, j_password는 정해져 있는대로 사용하는 것임
	-->
	<form name="loginForm" action="j_security_check" method="POST">
		<p>ID : <input type="text" name="j_username"/></p>
		<p>비밀번호 : <input type="password" name="j_password"/></p>
		<p><input type="submit" value="로그인"/></p>
	</form>
</body>
</html>