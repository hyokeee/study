<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- <%@ page errorPage ="exception_error.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
<title>Exception</title>
</head>
<body>
	<%	//스크립틀릿
	/*  post방식 
		요청URL : tryCatch_process.jsp
		요청파라미터 : {num1=12&num2=6n}	 */
		try{
			String num1 = request.getParameter("num1");	//"12"
			String num2 = request.getParameter("num2");	//"6"
			
			
			// 문자를 숫자로 형변환
			int a = Integer.parseInt(num1);	//12
			int b = Integer.parseInt(num2);	//6n <- 문제 발생
			int c = a / b ;
			out.print("<p>" + num1 + " / " + num2 + " = " + c+"</p>");
		}catch(NumberFormatException e){
			//오류 발생 시 tryCatch_error.jsp로 포워딩
			/*
				1) forwarding : jsp를 해석->컴파일->html리턴받음. 데이터를 전달할 수 있음
				2) redirect : URL을 재요청. 데이터를 전달하기 어려움
			*/
			//request객체와 response객체를 전달
			//tryCatch_error.jsp에서도 요청파라미터인 ?num1=12&num2=6n을 사용할 수 있게됨
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("tryCatch_error.jsp");
			dispatcher.forward(request, response);
		}
	%>
</body>
</html>