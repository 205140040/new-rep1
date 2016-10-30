<%@page import="com.alibaba.fastjson.JSON"%>
<%@page import="com.yfairy.user.bean.User"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Yfairy</title>
<jsp:include page="/css.jsp"></jsp:include>
</head>
<body>
	<!--navigation  -->
	<jsp:include page="/navigation.jsp"></jsp:include>

	<!--body  -->
	<div class="container-fluid body-space-left">
		<div class="row">
			<p>
				<%
					User user = (User) request.getAttribute("user");
					out.println("Name:" + user.getUsername());
					out.println("Sex:" + user.getSex());
					out.println("Age:" + user.getAge());
				%>
				&nbsp;&nbsp;&nbsp;&nbsp;段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容段落内容
			</p>
		</div>
	</div>

	<jsp:include page="/js.jsp"></jsp:include>
</body>
</html>