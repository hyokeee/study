<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>01.forward와 include 액션 태그의 차이점을 간단히 설명하시오.</h1>
<p>
	forward는 다른 페이지로 이동 즉, 페이지의 흐름을 제어하는 액션 태그다.<br/>
	코드가 실행되다 forward 태그가 실행될 때, 다른 페이지로 이동하며 그 뒤에 있는 코드들은 실행되지 않는다.<br/>
	페이지를 이동할 때 jsp:param을 통해 파라미터를 요청할 수 있다.<br/>
	buffer 임시공간에 실행된 코드의 값이 들어 있다가 forward가 실행될 때 버퍼가 지워지고 이동할 jsp파일의 값이 들어간다.<br/>
	
	include 액션 태그는 해당 include한 위치에 jsp파일이 첨부 되는 액션 태그다.<br/>
	코드가 실행되다 include 태그가 실행된 후 기존 jsp파일의 include 태그 이후 코드들이 실행된다.<br/>
	flush 속성을 true / false 중 어느 것으로 주는지에 따라 실행 과정이 차이가 있다.<br/>
	A - b(include) - C 로 진행될 때<br/>
	flush 속성을 true로 설정하면 버퍼 안에 A가 들어 왔다가 A를 크롬에 출력, 버퍼를 비우고 B가 버퍼에 들어옴, B를 크롬에 출력 후 버퍼 비우고 C에 버퍼 들어온 후 크롬에 C 출력<br/>
	false로 설정하면 버퍼 안에 A 쌓고 B 쌓고 C 쌓고 한번에 크롬에 출력<br/>

	flush 속성을 true로 설정하면, 포함된 내용이 처리되는 동안에도 브라우저로부터 응답이 전송되어 클라이언트는 부분적인 응답을 받을 수 있다.<br/>
	예를 들어, 페이지가 큰 테이블이나 데이터를 처리하는 경우, flush를 true로 설정하여 일부 데이터가 준비되는 즉시 사용자에게 표시할 수 있다.<br/>

	반대로, flush 속성을 false로 설정하면, include 액션 태그를 처리하는 동안에는 아무런 응답을 클라이언트로 보내지 않는다.<br/>
	전체 내용이 처리된 후에 한 번에 응답을 보내게 된다. 이 경우 사용자는 페이지의 모든 내용을 기다려야 하므로 응답이 느려질 수 있다.<br/>
	따라서, flush 속성을 명시적으로 false로 설정하지 않는 한, include 액션 태그의 flush 속성 값은 기본적으로 true다.
</p>

<h1>02.include 액션 태그와 include 디렉티브 태그의 차이점을 설명하시오</h1>
<p>
	둘 다 현재 jsp 페이지에 다른 jsp페이지의 코드를 포함하는 기능을 제공한다는 점에서는 비슷하다.<br/>
	하지만, include 디렉티브 태그(정적페이지)는 단순히 다른 페이지의 내용이 포함되지만, include 액션 태그(동적페이지)는 다른 페이지의 처리 결과 내용을 포함한다.<br/>
</p>

<h1>03.자바빈즈를 작성하는 기법을 예를 들어 설명하시오.</h1>
<p>
	자바 빈즈에는 멤버 변수, 기본생성자(생략 가능), getter/setter 메서드로 구성되어있다.<br/>
	VO class 파일은 DB에서 사용하는 테이블 명을 참고해 CamelCase로 작성해주고, 멤버 변수도 각 column값들에 대해 타입을 주어 camelCase로 처리한다.<br/>
	해당 멤버 변수들에 대해 getter/setter 메서드를 만들어주면 자바빈즈 클래스가 된다.
</p>
</body>
</html>