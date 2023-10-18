<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 서블릿에서 저장한 데이터를 꺼내기
ProdVO prodVo = (ProdVO) request.getAttribute("prodVo");

%>

{
	"id"      : "<%= prodVo.getProd_id() %>",
	"name"    : "<%= prodVo.getProd_name() %>",
	"lgu"     : "<%= prodVo.getProd_lgu() %>",
	"buyer"   : "<%= prodVo.getProd_buyer() %>",
	"cost"    : "<%= prodVo.getProd_cost() %>",
	"price"   : "<%= prodVo.getProd_price() %>",
	"sale"    : "<%= prodVo.getProd_sale() %>",
	"outline" : "<%= prodVo.getProd_outline() %>",
	"detail"  : "<%= prodVo.getProd_detail() %>",
	"size"    : "<%= prodVo.getProd_size() %>",
	"color"   : "<%= prodVo.getProd_color() %>"
}
