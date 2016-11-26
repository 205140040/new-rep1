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
<title>Yfairy-demo</title>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>
	<h2>Hello World!</h2>
	<img id="yzm" src="<%=BasePath%>/kaptcha/captchaImage">
	<a href="javascript:void(0)" onclick="changeCaptchaImage()">看不清?换一张</a>
	<script type="text/javascript">
		function changeCaptchaImage(){
			var date=new Date();
			var srccon='<%=BasePath%>/kaptcha/captchaImage?date=' + date;
			$("#yzm").attr("src", srccon);
		}
	</script>
</body>
</html>
