<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
label{
	display : inline-block;
	width : 80px;
}
</style>

<body>
	<% 		

		// JSP문서에서 세션객체는 'session'이라는 이름으로 이미 저장되어 있다.
		//로그인에 성공했을 때 저장한 세션 데이터 가져오기
		MemberVO memVo = (MemberVO) session.getAttribute("loginMember");
        if (memVo!=null) {		//로그인이 됐을 떄
    %>
            <h1><%=memVo.getMem_name() %>님 반갑습니다.</h1>
            <form action="<%=request.getContextPath()%>/sessionLogoutDB.do" method="post">
                <input type="submit" value="로그아웃">
            </form>
    <% 
    	} else { 			//로그인이 안되었을 때
    %>
            <h1>Login</h1>
            <form action="<%=request.getContextPath()%>/sessionLoginDB.do" method="post">
                <label for="userId">ID:</label>
                <input type="text" id="userId" name="userId"><br>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password"><br>
                <input type="submit" value="로그인">
            </form>
    <% 
    	} 
    %>
</body>
</html>