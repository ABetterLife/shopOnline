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
	<h1>未发货订单</h1>
    <table border="1" width="880">
    	<tr>
    		<th>用户</th>
    		<th>订单号</th>
    		<th>金额</th>
    		<th>订单状态</th>
    		<th>明细</th>
    	</tr>
    	<c:forEach items="${oss}" var="o">
    		<tr>
    			<td>${o.user.userName}</td>
	    		<td>${o.orderNum}</td>
	    		<td>￥${o.price}元</td>
	    		<td>${o.state==0?'未发货':'已发货'}</td>
	    		<td>
	    			<a href="${pageContext.request.contextPath}/ManagerServlet?operation=showOrdersDetail&ordersId=${o.id}">查看明细</a>
	    		</td>
	    	</tr>
    	</c:forEach>
    </table>
</body>
</html>