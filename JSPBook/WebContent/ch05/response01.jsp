<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Object(내장 객체)</title>
</head>
<body>
	<!-- 
	요청 URL : response01_process.jsp
	요청 파라미터 : {id=a001&passwd=java}
	 -->
	 <!-- 폼필드 -->
	<form action="response01_process.jsp" method = "post">
		<!-- 폼데이터 -->
		<p>
			아이디 : <input name="id" placeholder="아이디를 입력해주세요" required/>
			
		</p>
		<p>
			비밀번호 : <input name="passwd" placeholder="비밀번호를 입력해주세요" required/>
			
		</p>
		<p><input type="submit" value="전송"></p>
	</form>


</body>
</html>