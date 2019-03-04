<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/manager/header.jsp"%>
			
	订单号：${o.orderNum}&nbsp;&nbsp;金额：￥${o.price}元，明细如下：<br/>
	<table border="1" width="880" style="text-align: center">
		<tr>
			<th>商品名</th>
			<th>单价</th>
			<th>数量</th>
			<th>小计</th>
		</tr>
		<c:forEach items="${o.items}" var="i">
			<tr>
				<td>${i.goods.name}</td>
				<td>￥${i.goods.price}元</td>
				<td>${i.num }</td>
				<td>￥${i.price}元</td>
			</tr>
		</c:forEach>
	</table>
		<c:if test="${o.state==0}">
    <a href="${pageContext.request.contextPath}/ManagerServlet?operation=sureOrders&ordersId=${o.id}">确认发货</a>
    </c:if>
</body>
</html>