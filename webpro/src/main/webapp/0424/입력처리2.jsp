<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력처리2</title>
</head>
<body>
<h1>JSP : Java Server Page</h1>


<%

	request.setCharacterEncoding("UTF-8");
	String userId = request.getParameter("id");
	//기본 타입이 String이기 때뭉네 int로 바꿔줄 수 있음
	int userNum =  Integer.parseInt(request.getParameter("num"));
	//userFile은 실제 File이 아니고 String으로 가져온다(파일명만) ==> 그걸 가지고 파일처리를 해줘야함
	String userFile = request.getParameter("file");

	//db처리, 파일처리 - java i/o가 필요하다
	
	
%>

<p>아이디 : <%= userId %></p>
<p>번호 : <%= userNum %></p>
<p>파일 : <%= userFile %></p>
</body>
</html>