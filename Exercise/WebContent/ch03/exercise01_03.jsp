<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- 디렉티브 태그의 세 가지 유형에 대해 간단히 설명하시오 -->
<h1>01.디렉티브 태그의 세 가지 유형에 대해 간단히 설명하시오</h1>
<h3>1.page태그</h3>
<p>
	jsp 페이지에 대한 정보를 나타내는 디렉티브태그<br/>
	JSP페이지의 어디에서든 선언할 수 있지만, 일반적으로 최상단에 선언하는것을 권장
</p>
<h3>2.include태그</h3>
<p>
	현재 JSP페이지의 특정 영역에 외부 파일의 내용을 포함하는 태그<br/>
	JSP페이지 어디서든 선언 가능하다<br/>
	한 jsp파일 코드만 수정하면 모든 include한 jsp파일이 수정되기 때문에 재사용성이 좋다.
</p>
<h3>1.taglib태그</h3>
<p>
	현재 JSP페이지에 표현 언어, JSTL, 사용자 정의 태그 등 태그 라이브러리를 설정하는 태그<br/>
	접두사, URL을 지정해줘야 한다.<br/>
	tablib태그를 사용하려면 JSTL-1.2.jar 파일을 lib폴더에 추가해야한다. 
</p>
<hr/>
<br/>
<h1>02.JSP페이지가 사용할 자바 클래스를 설정하기 위한 page 디렉티브 태그의 속성은 무엇인가?</h1>
<p>
	import 속성
</p>
<hr/>
<br/>
<h1>03. JSP 페이지의 특정 영역에 외부 파일의 내용을 포함하는 디렉티브 태그는 무엇인가?</h1>
<p>
	include 태그
</p>
</body>
</html>