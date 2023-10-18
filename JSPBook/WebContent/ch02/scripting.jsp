<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Scripting Tag</title>
</head>
<body>

<h2>Scripting Tag</h2>

<!-- 선언문 : 변수, 메서드-->
<%!
//전역변수 초기화
int count = 3;

//전역 메서드.
//String : 리턴타입 / data : 파라미터(인수)를 받는 매개변수
//접근제한자 생략 시 open 범위는 ? 동일 패키지(default)
String makItLower(String data){
	//대문자 -> 소문자
	return data.toLowerCase();
}
%>
<% //스크립틀릿 태그(자바 로직 코드 작성)
//지역변수  i를 사용하고 1부터 3까지 1씩 증가
for(int i=1; i<=count; i++){
	//out(화면에 출력) : JSP 내장 객체
	out.print("J(자)SP(습)으로 실력향상! + " + i + "<br />");	
}
%>

<!-- 표현문 태그(선어문의 메서드를 호출) -->
<%= makItLower("Hello World") %>
</body>
</html>