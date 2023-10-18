<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>민우</h1>
<form action="/sec/logout" method="post">
	<sec:csrfInput/>
	<button>로그아웃!</button>
</form>
<input type="text" id="bj" value="범진"><br>
<button onclick="fAjax()">아작스전송</button>
<script>
	//csrf 토큰은 get방식에는 안 보내도 됨! (나머진 보내야 함)
	//서버에서 발행된 헤더네임과 토큰갑사 저장
	var header = '${_csrf.headerName}';
	var token =  '${_csrf.token}';
	var myBj = document.querySelector("#bj");
	

	function fAjax(){
		let xhr = new XMLHttpRequest();
		xhr.open("POST","/sec/angma/seoju",true);
		xhr.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				console.log(xhr.responseText);
			}
		}
		//바닐라 자바스크립트 사용시 AJAX send 전에 헤더값 세팅 필요
		xhr.setRequestHeader(header, token);
		xhr.send("mName="+myBj.value);
	}
</script>
</body>
</html>