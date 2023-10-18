<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Scripting Tag</title>
</head>
<body>

<%	//스크립틀릿 태그
	for(int i=0; i<=10; i++){
		//짝수일때만
		if(i%2==0 && i!=0){
			//out : JSP 기본객체(화면에 출력)
			out.print("<p>"+i+"</p>");
		}
	}
	

%>

</body>
</html>