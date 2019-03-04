<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
    <%@ include file="/manager/header.jsp" %>
    <h4>添加新的分类</h4>
    <form action="${pageContext.request.contextPath}/ManagerServlet?operation=addCategory" method="post">
    <table border="1" width="66%">
    <tr>
        <td>分类名称</td>
        <td><input type="text" name="name"/></td>
    </tr>
    <tr>
        <td>描述</td>
        <td><textarea rows="3" cols="38" name="description"></textarea></td>
    
    </tr>
    <tr>
        <td colspan="2">
          <input type="submit" value="保存"/>
        </td>
    </tr>
    </table>
    </form>
     ${message}
</body>
</html>