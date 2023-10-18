<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="vo.UsersVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	//스크립틀릿
/* 요청URL : validation05_process.jsp
요청파라미터 : {id=a001,passwd=1234, name=개똥이,phone1=010,phone2=1234,phone3=2211,
			email=test@test.co.kr}
요청방식 : post */
request.setCharacterEncoding("utf-8");
String id     = request.getParameter("id");
String passwd = request.getParameter("passwd");
String name   = request.getParameter("name");
String phone1 = request.getParameter("phone1");
String phone2 = request.getParameter("phone2");
String phone3 = request.getParameter("phone3");
String email  = request.getParameter("email");

UsersVO usersVO = new UsersVO();
usersVO.setId(id);
usersVO.setName(name);
usersVO.setPasswd(passwd);
usersVO.setPhones(phone1, phone2, phone3);
usersVO.setEmail(email);

out.print("usersVO : " + usersVO);
%>
<c:set var="usersVO" value="<%=usersVO %>"/>
<p>아이디 :${usersVO.id }</p>
<p>비밀번호 : ${usersVO.getPasswd() }</p>
<p>이름 : ${usersVO.name }</p>
<p>연락처 : ${usersVO.phone }</p>
<p>이메일 : ${usersVO.email }</p>
	
