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
						<div class="col-md-8">
							Level 1: .col-md-8
							<div class="row">
								<div class="col-md-2 col-xs-6"
									style="background-color: #00ffc4;">Level 2: .col-xs-8
									.col-sm-6</div>
								<div class="col-md-8 col-xs-4" style="background-color: green;">Level
									2: .col-xs-4 .col-sm-6</div>
							</div>
						</div>
					</div>
				</div>
				<p>3.3.3布局嵌套，</p>
				<p class="title">总结,bootstrap的布局就是容器+栅格系统(+嵌套+偏移)</p>
				<p>
					3.4响应式设计,通过css3媒体查询(Media Query)，实现响应式css,@media (min-width: 768px)
					{} <br>使用js实现响应式设计,css3-mediaqures.js工具 <br>3.4.6响应式bootstrap设计,3.X版默认就是responsive的。
				</p>
				<div class="container-fluid">
					<p>响应式工具

						为了加快对移动设备友好的页面开发工作，利用媒体查询功能并使用这些工具类可以方便的针对不同设备展示或隐藏页面内容。另外还包含了针对打印机显示或隐藏内容的工具类。

						有针对性的使用这类工具类，从而避免为同一个网站创建完全不同的版本。相反，通过使用这些工具类可以在不同设备上提供不同的展现形式。

						可用的类 通过单独或联合使用以下列出的类，可以针对不同屏幕尺寸隐藏或显示页面内容。 超小屏幕 手机 (<768px) 小屏幕 平板
						(≥768px) 中等屏幕 桌面 (≥992px) 大屏幕 桌面 (≥1200px) .visible-xs-* 可见 隐藏 隐藏
						隐藏 .visible-sm-* 隐藏 可见 隐藏 隐藏 .visible-md-* 隐藏 隐藏 可见 隐藏
						.visible-lg-* 隐藏 隐藏 隐藏 可见 .hidden-xs 隐藏 可见 可见 可见 .hidden-sm 可见 隐藏
						可见 可见 .hidden-md 可见 可见 隐藏 可见 .hidden-lg 可见 可见 可见 隐藏 从 v3.2.0
						版本起，形如 .visible-*-* 的类针对每种屏幕大小都有了三种变体，每个针对 CSS 中不同的 display
						属性，列表如下：</p>
					<div class="hidden-md" style="background-color: #00ffc4;">中等屏幕隐藏</div>
					<p class="title">第4章：优化css样式</p>
					<div>
						<div style="text-indent: 1em;">
							<h2>《出塞》</h2>
							<p>作者：王之涣</p>
							<p>.lead段落突出显示</p>
							<p class="lead">黄河远上白云间，一片孤城万仞山。</p>

							<p class="lead">羌笛何须怨杨柳，春风不度玉门关。</p>
						</div>
						<p>
							4.1.2文本强调风格:em斜体,"b,strong"强调粗体 <br> <strong>strong</strong>
							<br> <em>斜体文字</em>
						</p>
						<p>情境文本颜色 通过颜色来展示意图，Bootstrap
							提供了一组工具类。这些类可以应用于链接，并且在鼠标经过时颜色可以还可以加深，就像默认的链接一样。</p>
						<p class="text-muted">text-muted</p>
						<p class="text-primary">text-primary</p>
						<p class="text-success">text-success</p>
						<p class="text-info">text-info...</p>
						<p class="text-warning">text-warning...</p>
						<p class="text-danger">text-danger...</p>
						<p><small>small标签缩小文字</small></p>
						<p>4.1.3文本对齐风格</p>
						<p class="text-lfet">左对齐</p>
						<p class="text-center">居中</p>
						<p class="text-right">右对齐</p>
						<p class="lead">4.1.4缩略语
						<abbr title="css is 层叠样式表">css</abbr>
						</p>
						<p>4.1.5地址风格:<address>欢迎来到英雄联盟</address></p>
						<p>4.1.7列表风格 dao 107</p>
					</div>
				</div>
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