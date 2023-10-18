<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<title>Session</title>
</head>
<body>
<%	
	/*
	session.setAttribute("속성명",데이터)
	데이터 : Object객체 타입만 가능함. int(x), double(x), char(x)
	*/
	String name;	//세션 속성 명
	String value;	//세션 값
	//session 내장 객체 내 어떤 속성값들이 있는지 ???
	Enumeration en =  session.getAttributeNames();
	// 세션 속성 명이 있을 때 가지만 반복
	while(en.hasMoreElements()){
		name = en.nextElement().toString();
		value = session.getAttribute(name).toString();
		
		out.print("설정된 세션 속성 명 : " + name + "<br/>");
		out.print("설정된 세션 속성 값 : " + value + "<br/><br/>");
		
	}
%>
</body>
</html>