<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//전송시 데이터를 받는다
	request.setCharacterEncoding("utf-8");
    String userName = request.getParameter("name");
    String  userAge = request.getParameter("age");
	//DB처리 수행 
	
	//수행 결과를 얻는다
	
	//수행결과로 응답 데이터를 생성한다 - json 객체

%>

{
   "name" : "<%= userName %>",
   "age"  : "<%= userAge %>"
}