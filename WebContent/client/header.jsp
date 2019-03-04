<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<html>
<head>
<title></title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center;">
</br>
<a href="${pageContext.request.contextPath}">商城首页</a>
<span style="width:800px"></span>
<c:if test="${sessionScope.user==null}">
<a href="${pageContext.request.contextPath}/client/login.jsp">登录</a>
<a href="${pageContext.request.contextPath}/client/register.jsp">注册</a>
</c:if>
<c:if test="${sessionScope.user!=null}">
${sessionScope.user.userName}&nbsp;&nbsp;<a href="#">注销</a>
</c:if>
<a href="${pageContext.request.contextPath}/ClientServlet?operation=showUsersOrders">我的订单</a>&nbsp;&nbsp;
<c:if test="${sessionScope.user!=null}">
<a href="${pageContext.request.contextPath}/client/showCart.jsp">购物车</a>
</c:if>
<c:if test="${sessionScope.user==null}">
<a href="${pageContext.request.contextPath}/client/login.jsp">购物车</a>
</c:if>
<script language="javascript">
	function qiehuan(num){
		for(var id = 0;id<=9;id++)
		{
			if(id==num)
			{
				document.getElementById("qh_con"+id).style.display="block";
				document.getElementById("mynav"+id).className="nav_on";
			}
			else
			{
				document.getElementById("qh_con"+id).style.display="none";
				document.getElementById("mynav"+id).className="";
			}
		}
	}
</script>

<div id=menu_out>
  <div id=menu_in>
    <div id=menu>
      <UL id=nav>
        <LI><A class=nav_on id=mynav0 onmouseover=javascript:qiehuan(0) href="#"><SPAN>所有分类</SPAN></A></LI>
        <LI class="menu_line"></LI>
      </UL>
      <div id=menu_con>
        <div id=qh_con0 style="DISPLAY: block">  <!-- block前后换行 -->
          <UL>
           	<c:forEach items="${sessionScope.list}" var="c">
	            <LI><A href="${pageContext.request.contextPath}/ClientServlet?operation=showCategoryGoods&category_id=${c.id}"><SPAN>${c.name}</SPAN></A></LI>
	            <LI class=menu_line2></LI>
           	</c:forEach>
          </UL>
        </div>
      </div>
      
</div>
</div>
</div>
 
</body>
</html>