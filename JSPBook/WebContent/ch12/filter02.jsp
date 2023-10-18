<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>filter</title>
</head>
<body>
	<!-- 사용자가 입력한 요청파라미터
	   /filter02_process.jsp
	   {id=admin&passwd=1234}
	-->
	<form action="filter02_process.jsp" method="post">
		<p>id : <input type="text" name="id"/></p>
		<p>pw : <input type="password" name="passwd"/></p>
		<p><input type="submit" value="전송"/></p>
	</form>
</body>
</html>