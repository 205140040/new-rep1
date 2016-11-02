<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no"
	id="viewport" name="viewport">
<title>Yfairy</title>
<jsp:include page="/css.jsp"></jsp:include>
</head>
<body>
	<!--navigation  -->
	<jsp:include page="/navigation.jsp"></jsp:include>

	<!--body  -->
	<div class="container-fluid body-space-left">
		<h2>Hello,World!</h2>
	</div>

	<jsp:include page="/js.jsp"></jsp:include>
</body>
</html>