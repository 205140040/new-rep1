<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>bootstrap</title>
<!-- Bootstrap -->
<link
	href="<%=BasePath%>/js/bootstrap-3.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.title {
	color: #66FFFF;
	text-align: center;
}
</style>
</head>
<body>
	<h1 class="title">第一章</h1>
	<p>第30页,bootstrap开发工具:1.jetStrap,2.layoutIt</p>
	<h1 class="title">第2章,dao 43ye</h1>
	<p>
	<h2 class="btn btn-success">
		<i class="glyphicon glyphicon-user"></i>Hello World
	</h2>
	</p>
	<!-- jQuery  -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- bootstrap.min.js -->
	<script
		src="<%=BasePath%>/js/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
</body>
</html>