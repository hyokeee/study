<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
<script>
	function checkLogin(){
		let form = document.loginForm;
		//1) 아이디는 영문 소문자만 입력 가능
		//form.id.value : admin (length:5)
		for(i=0; i<form.id.value.length; i++){
			let ch = form.id.value.charAt(i);
			if(ch < 'a'|| ch >'z' && ch>='A'||ch<='Z' && ch>='0'||ch<='9'){
				alert("아이디는 영문 소문자만 입력 가능합니다");
				form.id.select();
				return;	//함수를 멈춤. break는 for문을 멈추는 반면에, return은 함수 자체를 멈춤
			}
		} // endfor
		//2) 비밀번호는 숫자만 입력 가능
		// 이것은 숫자가 아니다(isNaN)
		if(isNaN(form.passwd.value)){
			alert("비밀번호는 숫자만 입력 가능 합니다");
			form.passwd.select();
			return;
		}
		// 아이디 및 비밀번호 유효성겁사(validation)을 통과 시
		form.submit();	// 폼 페이지에 입력된 데이터 값을 서버로 전송(request) 객체에 담아서
	}
</script>
</head>
<body>
<!-- body와 /body 사이를 document라고 한다 -->
	<!-- 요청URL : validation03_process.jsp
		 요청파라미터 : {id=a001,passwd=java}
		 요청방식 : post
	-->
	<form name="loginForm" action="validation03_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id"/></p>
		<p>비밀번호 : <input type="password" name="passwd"/></p>
		<!-- checkLogin() : 핸들러함수 -->
		<p><input type="button" value="전송" onclick="checkLogin()"/></p>
	</form>
</body>
</html>