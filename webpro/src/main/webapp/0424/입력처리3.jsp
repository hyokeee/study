<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table{
	border : 2px solid blue;
}
td{
	width : 300px;
	height : 50px;
	text-align: center;
}

</style>
</head>
<body>
	<h1>JSP : Java Server Page</h1>
	<p>클라이언트의 요청(request)을 받아서 서버내에서 처리하는 서버 프로그램</p>
	<p>서버내 처리 결과를 클라이언트로 응답(response)한다</p>

	<!-- html 주석처리 -->
	
	<%
		//자바 문장에서는 <!-- --> 사용하면 안됨
		
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("id");
		String userName = request.getParameter("name");	
		String gender = request.getParameter("gender");
		//참조 변수기때문에 주솟값이 나온다
		String[] likes = request.getParameterValues("hobby");
		
		//likes 배열을 출력하기 위한 for문.
		String str = "";
		for(String like : likes){
			str += like;
		}
		
		/*
		 같은 표현
		 for(int i = 0; i<likes.length; i++){
		 	str += likes[i] + " ";
		 }
		*/
	%>
	
	<table border="1">
	<tr>
		<td>아이디</td>
		<td> <%= userId %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td> <%= userName %></td>
	</tr>
	<tr>
		<td>성별</td>
		<td> <%= gender %></td>
	</tr>
	<tr>
		<td>취미</td>
		<td> <%= str %></td>
	</tr>
	</table>

</body>
</html>