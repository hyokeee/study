<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Scripting Tag</title>
</head>
<body>

<%! //선언문태그
	//a, b : 정수형 매개변수
	//리턴 타입(정수형)
	//전역 메서드
	int sum(int a, int b){
		return a + b;
	}
%>

<%
	//sum이라는 전역메서드를 호출(두 개의 파라미터 전달)
	out.println("2 + 3 = " + sum(2,3));
%>

</body>
</html>