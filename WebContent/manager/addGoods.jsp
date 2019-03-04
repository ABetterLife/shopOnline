<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/manager/header.jsp" %>
<html>
<body>
<h2>添加新的商品</h2>
<!-- enctype 属性规定在发送到服务器之前应该如何对表单数据进行编码。 
      multipart/form-data不对字符进行编码  
              在使用包含文件上传控件的表单时，必须使用该值。-->
<form action="${pageContext.request.contextPath}/ManagerServlet?operation=addGoods" 
       method="post" enctype="multipart/form-data">
       <table border="1" width="80%">
       <tr>
       <td>商品名</td>
       <td><input type="text" name="name"/></td>
       </tr>
       
       <tr>
       <td>售价</td>
       <td><input type="text" name="price"/></td>
       </tr>
       
       <tr>
       <td>图片</td>
       <td><input type="file" name="image"/></td>
       </tr>
       
       <tr>
       <td>描述</td>
       <td>
       <textarea rows="3" cols="38" name="description"></textarea>
       </td>
       </tr>
       
       <tr>
       <td>所属分类</td>
      <td>
      <select name="category_id">
	    		<c:forEach items="${list}" var="c">
	    		<option value="${c.id}">${c.name}</option>
	    		</c:forEach>
 
      </select>
      </td>
       </tr>
       
       <tr>
       <td>
       <input type="submit" value="保存"/>
       </td>
       </tr>
       </table>
</form>
${message}
</body>
</html>