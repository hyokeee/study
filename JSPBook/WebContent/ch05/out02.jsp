<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Object</title>
</head>
<body>
	<!-- 폼필드 -->
	<%--
		요청 URL : out02_process.jsp
		요청 방식   : post
		요청파라미터(HTTP 파라미터, QueryString) : {id=a001,passwd=java}
	 --%>
	<form action="out02_process.jsp" method="post">
		<!-- 폼데이터
		필수 : mandatory
		선택 : optional
		 -->
		<p>아이디 : <input type="text" name="id" 
					placeholder="아이디를 입력해주세요" required/></p>
		<p>비밀번호 : <input type="text" name="passwd"
					placeholder="비밀번호를 입력해주세요 " required/></p>
		<!-- button type ==> submit / button / reset -->
		<p><button type="submit">전송</button></p>
		
	</form>
</body>
</html>