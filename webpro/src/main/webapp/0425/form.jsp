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

</style>



</head>
<body>
<h1>JSP : Java Server Page</h1>

<%
request.setCharacterEncoding("UTF-8");
String userName = request.getParameter("name");
String userAddr = request.getParameter("addr");
String userMail = request.getParameter("mail");
String gender = request.getParameter("gender");
String userArea = request.getParameter("area");	

String area = userArea.replaceAll("\n" , "<br>");


%>


<p>이름 : <%= userName %></p>
<p>주소 : <%= userAddr %></p>
<p>메일 : <%= userMail %></p>
<p>성별 : <%= gender %></p>
<p>내용 : <%= area %></p>





</body>
</html>