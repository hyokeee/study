<%@page import="kr.or.ddit.board.vo.PageVO"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
PageVO pvo = (PageVO)request.getAttribute("vo");
%>

[
<%
for(int i=0; i<list.size(); i++) {
   BoardVO vo = list.get(i);
   if(i>0)out.print(",");

%>
   {
   "writer" : "<%= vo.getWriter() %>",
   "subject" : "<%= vo.getSubject() %>",
   "email" : "<%= vo.getMail() %>",
   "hit" : "<%= vo.getHit() %>",
   "wdate" : "<%= vo.getWdate() %>",
   "num" : "<%= vo.getNum() %>",
   "content" :"<%=vo.getContent() %>"
   }

   
<%
}
%>
]