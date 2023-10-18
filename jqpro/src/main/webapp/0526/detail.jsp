<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//서블릿에서 저장한 결과를 꺼내기
BuyerVO buyerVo = (BuyerVO)request.getAttribute("buyerVo");

%>

{
	"id"       : "<%= buyerVo.getBuyer_id() %>",
	"name"     : "<%= buyerVo.getBuyer_name() %>",
	"lgu"      : "<%= buyerVo.getBuyer_lgu() %>",
	"bank"     : "<%= buyerVo.getBuyer_bank() %>",
	"bankno"   : "<%= buyerVo.getBuyer_bankno() %>",
	"bankname" : "<%= buyerVo.getBuyer_bankname() %>",
	"zip"      : "<%= buyerVo.getBuyer_zip() %>",
	"add1"     : "<%= buyerVo.getBuyer_add1() %>",
	"add2"     : "<%= buyerVo.getBuyer_add2() %>",
	"comtel"   : "<%= buyerVo.getBuyer_comtel() %>",
	"mail"     : "<%= buyerVo.getBuyer_mail() %>"
}