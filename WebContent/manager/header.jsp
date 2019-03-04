<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.custom.com/jsp/jstl/functions" prefix="myfn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.2.min.js"></script>
<script type=text/javascript>
$(function(){
	$('#mobanwang_com li').hover(function(){
		$(this).children('ul').stop(true,true).show('slow');
	},function(){
		$(this).children('ul').stop(true,true).hide('slow');
	});
	
	$('#mobanwang_com li').hover(function(){
		$(this).children('div').stop(true,true).show('slow');
	},function(){
		$(this).children('div').stop(true,true).hide('slow');
	});
});
</script>
  <link href="${pageContext.request.contextPath}/css/css2.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center">
</br>
<h1><b>网上购物后台管理</b></h1>
<!--  
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
      <ul id=nav>
        <li><A class=nav_on id=mynav0 onmouseover=javascript:qiehuan(0) href="#"><SPAN>分类管理</SPAN></A></li>
        <li class="menu_line"></li>
        <li><a href="#" onmouseover="javascript:qiehuan(1)" id="mynav1" class="nav_off"><span>图书管理</span></a></li>
        <li class="menu_line"></li>
        <li><a href="#" onmouseover="javascript:qiehuan(2)" id="mynav2" class="nav_off"><span>订单管理</span></a></li>
        <li class="menu_line"></li>
        
        
      </ul>
      <div id=menu_con>
        <div id=qh_con0 style="DISPLAY: block">
          <UL>
            <LI><a href="${pageContext.request.contextPath}/manager/addCategory.jsp"><span>添加分类</span></A></LI>
            <LI class=menu_line2></LI>
            <LI><A href="${pageContext.request.contextPath}/ManagerServlet?operation=showAllCategory"><SPAN>查询分类</SPAN></A></LI>
            <LI class=menu_line2></LI>
           
          </UL>
        </div>
        <div id=qh_con1 style="DISPLAY: none">
          <UL>
            <LI><a href="${pageContext.request.contextPath}/ManagerServlet?operation=showAllCategoryUI"><span>添加商品</span></A></LI>
            <LI class=menu_line2></LI>
            <LI><A href="${pageContext.request.contextPath}/ManagerServlet?operation=showAllGoods"><SPAN>查询商品</SPAN></A></LI>
            <LI class=menu_line2></LI>
           
          </UL>
        </div>
        <div id=qh_con2 style="DISPLAY: none">
          <UL>
            <LI><a href="#"><span>待处理订单</span></A></LI>
            <LI class=menu_line2></LI>
            <LI><A href="#"><SPAN>已处理订单</SPAN></A></LI>
            <LI class=menu_line2></LI>
           
          </UL>
        </div>
        
      </div>
    </div>
  </div>
</div>
-->
<ul id="mobanwang_com" class="first-menu">
<li><a href="#" style="color:#ff0; background:none; border:none;" target="_self">霖霖商城</a></li>
<li><a href="#" target="_self">分类管理</a>
    <ul style="display: none;" id="subMusic" class="second-menu">
      <li><a href="${pageContext.request.contextPath}/manager/addCategory.jsp" class="mobanwang" target="_self">添加分类</a></li>
      <li><a href="${pageContext.request.contextPath}/ManagerServlet?operation=showAllCategory" class="mobanwang" target="_self">查询分类</a></li>
      </ul>
      </li>
      
      <li><a href="#" target="_self">商品管理</a>
    <ul id="subNews" class="second-menu">
      <li><a href="${pageContext.request.contextPath}/ManagerServlet?operation=showAllCategoryUI" class="mobanwang" target="_self">添加商品</a></li>
        <li><a href="${pageContext.request.contextPath}/ManagerServlet?operation=showAllGoods" class="mobanwang" target="_self">查询商品</a></li>
        </ul>
        </li>
        
         <li><a href="#" target="_self">订单管理</a>
    <ul id="subNews" class="second-menu">
      <li><a href="${pageContext.request.contextPath}/ManagerServlet?operation=showAllOrders0" class="mobanwang" target="_self">待处理订单</a></li>
        <li><a href="${pageContext.request.contextPath}/ManagerServlet?operation=showAllOrders1" class="mobanwang" target="_self">已处理订单</a></li>
        </ul>
        </li>
        <li><a href="#" style="color:#ff0; background:none; border:none;" target="_self">良心品质</a></li>
</ul>
</body>
</html>