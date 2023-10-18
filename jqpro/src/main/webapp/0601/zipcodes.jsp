<%@page import="kr.or.ddit.member.vo.ZiptbVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<ZiptbVO> list = (List<ZiptbVO>) request.getAttribute("list");
%>

[
<%
	for(int i= 0; i<list.size(); i++){
		ZiptbVO vo = list.get(i);
		if(i>0) out.print(",");
		if(vo.getBunji()==null) vo.setBunji("");
%>
	{
		"zipcode" : "<%= vo.getZipcode() %>",
		"addr" : "<%= vo.getSido()%> <%= vo.getGugun() %> <%= vo.getDong() %>",
		"bunji" : "<%= vo.getBunji() %>"
	}	


<%
	}
%>
	
]









