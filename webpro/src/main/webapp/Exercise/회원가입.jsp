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
String userMail = request.getParameter("mail");
String userMail2 = request.getParameter("mail2");
String userGender = request.getParameter("gender");
String userBir = request.getParameter("bir");
String userHobby[] = request.getParameterValues("hobby");
String hobby = " ";
for(String h : userHobby){
	hobby += h;
}
String intro = request.getParameter("intro");
String userIntro = intro.replaceAll("\n","<br>");

%>

<p>아이디 : <%=userId %></p><br>
<p>비밀번호 : <%=userPw %></p><br>
<p>이메일 : <%=userMail %> @<%=userMail2 %></p><br>
<p>성별 : <%=userGender %></p><br>
<p>생년월일 : <%=userBir %></p><br>
<p>취미 : <%=hobby %></p><br>
<p>자기소개 : <%=userIntro %></p><br>


</body>
</html>