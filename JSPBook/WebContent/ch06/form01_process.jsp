<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- 요청URL : form01_process.jsp
	  요청방식 : post방식
	  요청파라미터(HTTP파라미터=QueryString) :
	  {id=a001, passwd=java, name=개똥이, 
	   phone1=010, phone2=1234, phone3=1234,
	   gender=female, hobby={reading,exercise}, 
	   comment=가입할게요
	  }
-->
<%	//스크립틀릿
	//request객체의 encoding 처리
	request.setCharacterEncoding("utf-8");

	//모든 파라미터의 타입은 String 타입
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String gender = request.getParameter("gender");
	//hobby={reading,exercise]
	//배열에 저장된 취미 값을 문자타입 배열로 저장
	String[] hobby = request.getParameterValues("hobby");
	String comment = request.getParameter("comment");
%>
<!-- 폼 데이터 -->
<p>아이디 : <%=id %></p>
<p>비밀번호 : <%=passwd %></p>
<p>이름 : <%=name %></p>
<p>연락처 : 
	<%=phone1 %>-<%=phone2 %>-<%=phone3 %>
</p>
<p>성별 : 
	<%=gender %>
</p>
<p>취미 : 
	<%
		//체크박스의 특성상 체크를 하지 않았을 경우 실행 안함
		if(hobby!=null||hobby.length!=0){
			for(String h : hobby){
				out.print(" "+h);
			}
		}
	%>
</p>
<p>가입 인사 : <%=comment %></p>
<!-- <p><input type="submit" value="가입하기"/></p>
<p><input type="reset" value="다시쓰기"/></p> -->
