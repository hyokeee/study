<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	//전송 데이터 받기

	//  DB처리  = 결과값을 받는다.
	
	// 1.SqlSessionFactory - mabatis-config.xml(db설정, voalias 설정, mapper설정이 필요)
	// 2.SqlSession
	// 3.SqlSession 객체로 mapper의 SQL문장들을 수행
	
	SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
	
	List<MemberVO> list = sqlSession.selectList("member.getAllMember");
	//결과 값을 출력한다.
	
%>
[

<%
	for(int i=0; i<list.size(); i++){
		MemberVO vo = list.get(i);
		if(i>0) out.println(",");
%>
		{
			"id" : "<%= vo.getMem_id() %>",
	   		"name" : "<%= vo.getMem_name() %>",
	   		"tel" : "<%= vo.getMem_tel() %>",
	   		"addr" : "<%= vo.getMem_addr() %>"
		}
<%	
	}
%>

]
