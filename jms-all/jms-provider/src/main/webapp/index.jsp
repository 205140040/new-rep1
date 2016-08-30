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
<link href="<%=BasePath%>/js/bootstrap-3.3.5/dist/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<style>
.title {
	color: #ff6666;
	text-indent: 1em;
	font-size: 1.5em;
}
</style>
</head>
<body>

	<div class="panel-body">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs">
			<li class="active"><a href="#home" data-toggle="tab">Home</a></li>
			<li class=""><a href="#profile" data-toggle="tab">Profile</a></li>
			<li class=""><a href="#messages" data-toggle="tab">Messages</a>
			</li>
			<li class=""><a href="#settings" data-toggle="tab">Settings</a>
			</li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane fade active in" id="home">
				<h4>Home Tab</h4>
				<p class="title">第一章</p>
				<p>第30页,bootstrap开发工具:1.jetStrap,2.layoutIt</p>
				<p class="title">第2章</p>
				<p>
					简单的列子: <a class="btn btn-success"> <i
						class="glyphicon glyphicon-user"></i>Hello World
					</a> 导航页
				</p>
				<p class="title">第3章:bootstrap框架解析</p>
				<p>
					3.2.1网页栅格系统的设计方法 <br>以前大多数显示器是960宽度.960栅格 <br>
					3.2.3bootstrap栅格系统:1.固定式的(fix),2.流式的(fluid,可适应宽度的) <br>
					使用单一的一组 .col-md-*
					栅格类，就可以创建一个基本的栅格系统，在手机和平板设备上一开始是堆叠在一起的（超小屏幕到小屏幕这一范围），在桌面（中等）屏幕设备上变为水平排列。所有“列（column）必须放在
					” .row 内。
				</p>
				<div class="container">
					<div class="row show-grid">
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
						<div class="col-md-1">.col-md-1</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-3" style="background-color: grey;">col-md-3</div>
						<div class="col-md-6" style="background-color: yellow;">col-md-6</div>
						<div class="col-md-3" style="background-color: blue;">col-md-3</div>
					</div>
				</div>
				<p>实例：流式布局容器 将最外面的布局元素 .container 修改为
					.container-fluid，就可以将固定宽度的栅格布局转换为 100% 宽度的布局</p>
				<div class="container-fluid">
					<div class="row show-grid">
						<div class="col-md-8" style="background-color: blue;">.col-md-8</div>
						<div class="col-md-4" style="background-color: pink;">.col-md-4</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-4">.col-md-4</div>
						<div class="col-md-4">.col-md-4</div>
						<div class="col-md-4">.col-md-4</div>
					</div>
					<div class="row show-grid">
						<div class="col-md-6">.col-md-6</div>
						<div class="col-md-6">.col-md-6</div>
					</div>
				</div>
				<p>栅格偏移col-md-offset-(n)如col-md-offset-4偏移四格</p>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-4" style="background-color: pink;">.col-md-4</div>
						<div class="col-md-4 col-md-offset-4"
							style="background-color: #00ffc4;">偏移4格.col-md-4</div>
					</div>
				</div>
				<p>嵌套列 为了使用内置的栅格系统将内容再次嵌套，可以通过添加一个新的 .row 元素和一系列 .col-sm-*
					元素到已经存在的 .col-sm-*
					元素内。被嵌套的行（row）所包含的列（column）的个数不能超过12（其实，没有要求你必须占满12列）。</p>
				<div class="container-fluid">
					<div class="row">
						<div class="col-sm-9">
							Level 1: .col-sm-9
							<div class="row">
								<div class="col-xs-8 col-sm-6"
									style="background-color: #00ffc4;">Level 2: .col-xs-8
									.col-sm-6</div>
								<div class="col-xs-4 col-sm-6" style="background-color: green;">Level
									2: .col-xs-4 .col-sm-6</div>
							</div>
						</div>
					</div>
				</div>
				<p>3.3.3布局嵌套，75页</p>
			</div>
			<div class="tab-pane fade" id="profile">
				<h4>Profile Tab</h4>
			</div>
			<div class="tab-pane fade" id="messages">
				<h4>Messages Tab</h4>
			</div>
			<div class="tab-pane fade" id="settings">
				<h4>Settings Tab</h4>
			</div>
		</div>
	</div>
	<!-- jQuery  -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- bootstrap.min.js -->
	<script src="<%=BasePath%>/js/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
</body>
</html>