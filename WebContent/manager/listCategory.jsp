<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<body>
<%@ include file="/manager/header.jsp" %>
<h4>分类列表</h4>
<c:if test="${empty list}">
没有分类，请先添加
</c:if>
<c:if test="${!empty list }">
<table border="1" width="90%">
    <tr>
        <th>选择</th>
        <th>分类名称</th>
        <th>分类描述</th>
        <th>操作</th>
     </tr>
 <c:forEach items="${list}" var="c">
 <tr>
 <td>
 <input type="checkbox" name="ids" value="${c.id}"/>
 </td>
<td>${c.name}</td>
<td>${c.description}</td>
    <td>
    <!-- 回到当前页面顶端 -->
    <a href="#">修改</a>
    <a href="#">删除</a>
    </td>
 
 </tr>
 </c:forEach>
</table>
</c:if>

</body>
</html>