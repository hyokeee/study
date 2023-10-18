<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Result</h1>
<!-- model.addAttribute("memberVO",memberVO); -->
<h4>주소</h4>
<!-- memberVO.setAddressVO(addressVO); -->
<p>${memberVO.addressVO.zonecode }</p>
<p>${memberVO.addressVO.address }</p>
<p>${memberVO.addressVO.buildingName }</p>

<h4>보유카드</h4>
<!-- memberVO.setCardVOList(cardVOList);
	memberVO.cardVOList => List<CardVO>
-->
<c:forEach var="cardVO" items="${memberVO.cardVOList}" varStatus="stat">
	<p>${cardVO.no} / ${cardVO.validMonth}</p>
</c:forEach>