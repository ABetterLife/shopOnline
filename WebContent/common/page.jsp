<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
<link href="../css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../css/admin.css" rel="stylesheet" type="text/css" />

		<link href="../css/demo.css" rel="stylesheet" type="text/css" />

		<link href="../css/seastyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.7.min.js"></script>
		<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<span style="display: block">第${page.pageNum }页/共${page.totalPage}页</span>
<span><a href="${pageContext.request.contextPath}${page.url}&pageNum=${page.pageNum-1>0?page.pageNum-1:1}">上一页</a></span>
<a href="${pageContext.request.contextPath}${page.url}&pageNum=${page.pageNum+1>page.totalPage?page.totalPage:page.pageNum+1}">下一页</a>
</body>
</html>