<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{
	color : red;
}
p{
	background: yellow; 
	width : 600px;
}
table{
	border : 2px solid gold;
}
td{
	width : 300px;
	height : 50px;
}
</style>
</head>
<body>
<h1>JSP : Java Server Page</h1>
<p>html안에서 자바코드를 기술한다</p>
<p>기술된 자바코드는 서버내에서 실행되어진다</p>

<p>자바코드를 기술할 때는 &lt;% %> 기호 내에서 한다.</p>

<%
	//java코드 치는곳.
	//입력한 id, password를 받는다.name값을 이용해서(id, pw)
	String userId = request.getParameter("id");
	String userPass = request.getParameter("pw");
	//db처리 - crud처리를 한다.
	//결과값으로 응답페이지를 만든다
%>

<div>
   <table border="1">
   	<tr>
   		<td>아이디</td>
   		<td><%= userId %></td>
   	</tr>
   	<tr>
   		<td>비밀번호</td>
   		<td><%= userPass %></td>
   	</tr>
   </table>
</div>
</body>
</html>