<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="vo.MemberVO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	List<MemberVO> memberVOList =
		new ArrayList<MemberVO>();

	MemberVO vo = new MemberVO();
	vo.setUsername("a001");vo.setPassword("java");vo.setEnabled("1");
	memberVOList.add(vo);
	vo = new MemberVO();
	vo.setUsername("b001");vo.setPassword("java");vo.setEnabled("1");
	memberVOList.add(vo);
	vo = new MemberVO();
	vo.setUsername("c001");vo.setPassword("java");vo.setEnabled("1");
	memberVOList.add(vo);
	//JSP기본 객체 out
	out.print("memberVOList : " + memberVOList);
%>
<c:set var="memberVOList" value="<%=memberVOList%>" scope="page" />
<!DOCTYPE html>
<html>
<head>
<title>Directives Tag</title>
</head>
<body>
<table border="1">
<tr>
	<th>아이디</th>
	<th>비밀번호</th>
	<th>사용여부</th>
</tr>
<!-- List<MemberVO> memberVOList -->
<c:forEach var="memberVO" items="${memberVOList}" varStatus="stat">
<tr>
	<td>${memberVO.username}</td>
	<td>${memberVO.password}</td>
	<td>${memberVO.enabled}</td>
</tr>
</c:forEach>
</table>
</body>
</html>