<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
<LINK rel=stylesheet type=text/css href="css/lanrenxixi.css">
<SCRIPT type=text/javascript src="js/jquery.js"></SCRIPT>
<SCRIPT type=text/javascript src="js/mobanwang.js"></SCRIPT>
</head>
<body style="text-align:center">
<%@include file="/client/header.jsp"%>
<!--js开始 -->
<DIV id=js class="js"><IMG alt="" src="images/01.jpg"> 
<IMG style="DISPLAY: none" alt="" src="images/02.jpg">
<IMG style="DISPLAY: none" alt="" src="images/03.jpg"> 
<DIV id=jsNav class=jsNav>
<A id=prev class=prevBtn href="javascript:void(0)"></A>
<A class="trigger imgSelected" href="javascript:void(0)">1</A>
<A class=trigger href="javascript:void(0)">2</A>
<A class=trigger href="javascript:void(0)">3</A>
<A id=next class=nextBtn href="javascript:void(0)"></A>
</DIV>
</DIV>
<!--js结束-->
<!--  <h1>欢迎进入霖霖商城</h1>-->
<div id="content" class="goods">
<table>
   <tr>
   <c:forEach items="${page.records}" var="p">
      <td>
        <table class="product_box">
          <tr>
           <td><img src="${pageContext.request.contextPath}/files/${p.image}" alt="图片无法显示"/></td>
           </tr>
           <tr>
           <td>
                                         商品名:${p.name}<br/>
	    		    原价：<strike>888.00</strike><br/>
	    		<p class="product_price"> 震撼价:${p.price}</p>
           </td>
           </tr>
           <tr>
           <td><img src="images/resizeApi.png"/>
           <c:if test="${sessionScope.user!=null}">
           <a href="${pageContext.request.contextPath}/ClientServlet?operation=addCart&goodsId=${p.id}">加入购物车</a>
           </c:if>
           <c:if test="${sessionScope.user==null}">
           <a href="${pageContext.request.contextPath}/client/login.jsp">加入购物车</a>
           </c:if>
           </td>
          </tr>
         </table>
      </td>
      </c:forEach>
   </tr>
   <tr>
    		<td>
    			<%@include file="/common/page.jsp"%>
    		</td>
    	</tr>
</table>
</div>
${message}
</body>
</html>