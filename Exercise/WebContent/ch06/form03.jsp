<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Objects</title>
</head>
<body>
<form action ="form03_process.jsp" method="post">
	<label for="fruit1">오렌지</label>
	<input type="checkbox" value="Orange" id="fruit1" name="fruits">
	<label for="fruit2">사과</label>
	<input type="checkbox" value="Apple" id="fruit2" name="fruits">
	<label for="fruit3">바나나</label>
	<input type="checkbox" value="Banana" id="fruit3" name="fruits">
	<p><input type="submit" value="전송"/></p>
</form>
</body>
</html>