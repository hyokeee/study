<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- 로그인 실패 시 실행 
	로그인 실패
	1. 사용자 로그인 실패(인증 실패)
	->jogin.jsp로 강제 페이지 이동
	2. 로그인은 되지만 권한 없음(인가 실패
	->403오류 발생
-->
<%
	//요청 파라미터 : error=1
	response.sendRedirect("login.jsp?error=1");
%>