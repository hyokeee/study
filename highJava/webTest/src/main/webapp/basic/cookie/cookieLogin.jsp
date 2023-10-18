<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
label{
	display : inline-block;
	width : 60px;
}
</style>
</head>
<%
// 쿠키 정보를 읽어서 처리한다.
String idCookie ="";	// 쿠키값이 저장될 변수
String check = "";

Cookie[] cookieArr = request.getCookies();	// 전체 쿠키 정보 가져오기

for(Cookie cookie : cookieArr){

	if("id".equals(cookie.getName())){	// 원하는 쿠키이름 찾기
		idCookie = cookie.getValue();	// 쿠키값을 구한다.
		check = "checked";
	}else{
		check = "";
	}
}



%>
<body>

				
<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="post">
	<label for="id">ID :</label>
	<input name="id" placeholder="ID 입력하세요." value="<%=idCookie %>"><br>
	<label for="pw">PASS :</label>
	<input name="pw" placeholder="PassWord 입력하세요."><br>
	<input type="checkbox" name="check" value="check" <%= check %> > id 기억하기<br>
	<input id="btn" type="submit" value="Login">
</form>

</body>
</html>