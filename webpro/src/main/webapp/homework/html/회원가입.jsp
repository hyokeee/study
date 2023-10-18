<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입을 축하합니다!</h1>

<%

request.setCharacterEncoding("UTF-8");
String userId = request.getParameter("id");
String userPw = request.getParameter("pw");
String userCheckPw = request.getParameter("checkpw");
String userName = request.getParameter("name");
String userTel = request.getParameter("tel");
String userMail = request.getParameter("mail");
String userBir = request.getParameter("bir");
String userGender = request.getParameter("gender");


%>

<p>아이디 : <%=userId %></p><br>
<p>비밀번호 : <%=userPw %></p><br>
<p>이름 : <%=userName %></p><br>
<p>전화번호 : <%=userTel %></p><br>
<p>이메일 : <%=userMail %></p><br>
<p>성별 : <%=userGender %></p><br>
<p>생년월일 : <%=userBir %></p><br>


</body>
</html>