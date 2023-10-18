<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css"/>
<title>Login</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">로그인</h1>
		</div>
	</div>
	<div class="container" align="center">
		<div class="col-md-4 mol-md-offset-4">
			<h3 class="form-signin-heading">Please Sign In</h3>
		</div>
		<%
			String error = request.getParameter("error");
			if(error != null){
				out.print("<div class='alert alert-danger'>");
				out.print("아이디와 비밀번호를 확인해주세요");
				out.print("</div>");
			}
		%>
		<form class="form-signin" action="j_security_check" method="post">
			<div class="form-group">
				<label for="inputUserName" class="sr-only">User Name</label>
				<input type="text" id="inputUserName" class="form-control" placeholder="Id를 입력하세요"
					name="j_username" required autofocus/>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="sr-only">Password</label>
				<input type="password" id="inputPassword" class="form-control"
					placeholder ="Password를 입력해주세요"
					name = "j_password" required autofocus/>
			</div>
			<button type="submit" class="btn btn-lg btn-success btn-block">로그인</button>
		</form> 
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>