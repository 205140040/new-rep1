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
<title>uploadFile</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row col-xs-12 col-sm-12 col-md-2 col-lg-2">
			<img
				src="http://localhost:8081/yfairy-web-file/file/imageFile/jpg/eea3fb4e-0c98-4e1d-a1e6-acef84502675.jpg"
				alt="..." class="img-thumbnail">
		</div>
		<div class="row col-xs-12 col-sm-12 col-md-2 col-lg-2">
			<img
				src="http://localhost:8081/yfairy-web-file/file/imageFile/jpg/44fb9bbe-062d-4e24-92c2-3d76b7e52ab3.jpg"
				alt="..." class="img-thumbnail">
		</div>
		<div class="row col-xs-12 col-sm-12 col-md-2 col-lg-2">
			<img
				src="http://localhost:8081/yfairy-web-file/file/imageFile/jpg/91944049-92f3-4aa3-aa3a-5ce2a642f435.jpg"
				alt="..." class="img-circle" width="200" height="200">
		</div>
		<div class="row">
			<ol>
				<li><a
					href="http://localhost:8081/yfairy-web-file/file/downloadFile/jpg/91944049-92f3-4aa3-aa3a-5ce2a642f435.jpg">下载</a></li>
				<li><a
					href="/file/downloadFile/jar/b22e9d58-6e6b-42b6-bae1-7eb563195ded.jar">下载</a></li>

				<li><a href="<%=BasePath%>/hello/writeWord">下载Word</a></li>
			</ol>

		</div>
		<div class="row">
			<form id="f1" action="<%=BasePath%>/file/uploadFile" method="post"
				enctype="multipart/form-data">
				<label>文件名称</label><input type="file" name="file"><br>
				<input type="submit" class="btn btn-default" value="提交">
				<!-- <table class="table table-bordered">
				<tr>
					<td><label>文件名称</label><input type="file" name="file"></td>
				</tr>
				<tr>
					<td><button type="submit" class="btn btn-default">提交</button></td>
				</tr>
			</table> -->
			</form>
		</div>
	</div>
</body>
</html>