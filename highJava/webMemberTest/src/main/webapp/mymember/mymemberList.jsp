<%@page import="kr.or.ddit.member.vo.MyMemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#buttontd {
	text-align: right;
}
</style>
</head>
<%
	List<MyMemberVO> memList = (List<MyMemberVO>) request.getAttribute("memList");
%>
<body>
<table border="1">
<tr>
	<td id="buttontd" colspan="5"><input type="button" value="회원추가" id="insert" onclick="location.href='<%=request.getContextPath()%>/mymember/insert.jsp'"></td>
</tr>
<tr>
	<th>ID</th>
	<th>비밀번호</th>
	<th>이 름</th>
	<th>전 화</th>
	<th>주 소</th>
</tr>
<%
	if(memList ==null|| memList.size()==0){
%>
<tr>
	<td colspan ="5">회원 목록이 하나도 업습니다.</td>	
</tr>		
<%
	} else {
		for(MyMemberVO memVo : memList){
%>
<tr>
	<td><a href="<%=request.getContextPath()%>/detail.do?id=<%=memVo.getMem_id()%>"> <%=memVo.getMem_id() %> </a></td>
	<td><%=memVo.getMem_pass() %></td>
	<td><%=memVo.getMem_name() %></td>
	<td><%=memVo.getMem_tel() %></td>
	<td><%=memVo.getMem_addr() %></td>
</tr>

<%
		}
	}
%>			
</table>
</body>
</html>