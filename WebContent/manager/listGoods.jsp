<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
</head>
<body>
<%@include file="/manager/header.jsp" %>
<h4>商品列表</h4>
<table border="1" width="1024">
      <tr>
      <td>商品名</td>
      <td>价格</td>
      <td>描述</td>
      <td>所属分类</td>
      <td>图片</td>
      <td>操作</td>  
      </tr>
      <c:forEach items="${page.records}" var ="p"> 
      <tr>
      <td>${p.name }</td>
      <td>${p.price}</td>
      <td>${p.description}</td>
      <td>${myfn:getCategoryNameById(p.category_id)}</td>
      <td>
     <a href="${pageContext.request.contextPath}/files/${p.image}">查看图片</a>
      </td>
      <td>
	    			<a href="${pageContext.request.contextPath}/ManagerServlet?operation=updateGoods&goodsId=${p.id}">修改</a>
	    			<a href="${pageContext.request.contextPath}/ManagerServlet?operation=deleteGoods&goodsId=${p.id}">删除</a>
	  </td>
      </tr>
      </c:forEach>
     
</table>
<!-- 分页 -->
<%@include file="/common/page.jsp"%>
</body>
</html>