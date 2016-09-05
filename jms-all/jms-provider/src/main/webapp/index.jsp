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
<link href="<%=BasePath%>/css/lesstocss.css" type="text/css"
	rel="stylesheet">
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
			<li class=""><a href="#home" data-toggle="tab">Home</a></li>
			<li class=""><a href="#profile" data-toggle="tab">Profile</a></li>
			<li class="active"><a href="#messages" data-toggle="tab">Messages</a>
			</li>
			<li class=""><a href="#settings" data-toggle="tab">Settings</a>
			</li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane fade" id="home">
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
						<p>
							<small>small标签缩小文字</small>
						</p>
						<p>4.1.3文本对齐风格</p>
						<p class="text-lfet">左对齐</p>
						<p class="text-center">居中</p>
						<p class="text-right">右对齐</p>
						<p class="lead">
							4.1.4缩略语 <abbr title="css is 层叠样式表">css</abbr>
						</p>
						<p>4.1.5地址风格:
						<address>欢迎来到英雄联盟</address>
						<blockquote>引用标签，领先的 Web 技术教程 - 全部免费 在
							w3school，你可以找到你所需要的所有的网站建设教程。 从基础的 HTML 到 CSS，乃至进阶的XML、SQL、JS、PHP
							和 ASP.NET。 从左侧的菜单选择你需要的教程！</blockquote>
						</p>
						<p>4.1.7列表风格 dao 107</p>
						<p>无序列表
						<ul>
							<li>首页</li>
							<li>二手车</li>
							<li>二手车市场</li>
							<li>社区</li>
						</ul>
						有序列表
						<ol>
							<li>首页</li>
							<li>我的</li>
							<li>好友</li>
							<li>其他</li>
						</ol>
						无样式列表 移除了默认的 list-style
						样式和左侧外边距的一组元素（只针对直接子元素）。这是针对直接子元素的，也就是说，你需要对所有嵌套的列表都添加这个类才能具有同样的样式。
						<ul class="list-unstyled">
							<li>哈哈</li>
							<li>答案啊</li>
							<li>你在哪</li>
							<li>啦啦啦</li>
						</ul>
						列表显示在一行list-inline
						<ul class="list-inline">
							<li>一</li>
							<li>二</li>
							<li>三</li>
							<li>啦啦啦</li>
						</ul>
						</p>
						<p>
							4.1.8代码风格:
							<code>for(var i=0;i<3;i++){alert("重要的事说三遍");}</code>
							代码块 多行代码可以使用 'pre>' 标签。该标签会保留空格和换行
						<pre>class A{
							function com(){
								if(a>b){
									alert("a>b");
								}
							}
						}<a>bai</a>
						</pre>
						通过pre显示H5模板格式:
						<pre>&lt;!DOCTYPE HTML&gt;
&lt;html&gt;
&lt;body&gt;

&lt;video width="320" height="240" controls="controls"&gt;
  &lt;source src="movie.ogg" type="video/ogg"&gt;
  &lt;source src="movie.mp4" type="video/mp4"&gt;
Your browser does not support the video tag.
&lt;/video&gt;

&lt;/body&gt;
&lt;/html&gt;
</pre>
						</p>
						<p>4.21.表格优化设计</p>
						<div>
							表格 基本实例 为任意 'table>'标签添加 .table 类可以为其赋予基本的样式 —
							少量的内补（padding）和水平方向的分隔线。这种方式看起来很多余！？但是我们觉得，表格元素使用的很广泛，如果我们为其赋予默认样式可能会影响例如日历和日期选择之类的插件，所以我们选择将此样式独立出来。
							<table class="table">
								<caption>默认表格</caption>
								<thead>
									<tr>
										<th colspan="2">华语九天榜</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>排名</th>
										<th>歌曲名</th>
									</tr>
									<tr>
										<td>张三</td>
										<td>13</td>
									</tr>
									<tr>
										<td>李四</td>
										<td>13</td>
									</tr>
									<tr>
										<td>王五</td>
										<td>13</td>
									</tr>
									<tr>
										<td>赵六</td>
										<td>13</td>
									</tr>
								</tbody>
							</table>
							<p class="title">条纹状表格 通过 .table-striped 类可以给 'tbody>
								之内的每一行增加斑马条纹样式。</p>
							<table class="table table-striped">
								<caption>条纹状表格</caption>
								<thead>
									<tr>
										<th colspan="2">条纹状表格:华语九天榜</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>排名</th>
										<th>歌曲名</th>
									</tr>
									<tr>
										<td>张三</td>
										<td>13</td>
									</tr>
									<tr>
										<td>李四</td>
										<td>13</td>
									</tr>
									<tr>
										<td>王五</td>
										<td>13</td>
									</tr>
									<tr>
										<td>赵六</td>
										<td>13</td>
									</tr>
								</tbody>
							</table>
							<p class="title">4.2.3表格个性风格：dao 114</p>
							<p class="title">
								1.带边框的表格 添加 .table-bordered 类为表格和其中的每个单元格增加边框。 <br> 2.鼠标悬停
								通过添加 .table-hover 类可以让 'tbody> 中的每一行对鼠标悬停状态作出响应。 <br> 紧缩表格
								通过添加 .table-condensed 类可以让表格更加紧凑，单元格中的内补（padding）均会减半。 <br>
								状态类 通过这些状态类可以为行或单元格设置颜色。 Class 描述 .active 鼠标悬停在行或单元格上时所设置的颜色
								.success 标识成功或积极的动作 .info 标识普通的提示信息或动作 .warning 标识警告或需要用户注意
								.danger 标识危险或潜在的带来负面影响的动作 <br> 响应式表格 将任何 .table 元素包裹在
								.table-responsive 元素内，即可创建响应式表格，其会在小屏幕设备上（小于768px）水平滚动。当屏幕大于
								768px 宽度时，水平滚动条消失。
								<code> 'div class="table-responsive"> 'table
									class="table">... '/table> '/div> </code>
							</p>
							<div class="table-responsive">
								<table class="table table-bordered table-hover">
									<thead>
										<tr>
											<th colspan="15">条纹状表格:华语九天榜</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th>序号</th>
											<th>排名</th>
											<th>歌曲名</th>
											<th>序号</th>
											<th>排名</th>
											<th>歌曲名</th>
											<th>序号</th>
											<th>排名</th>
											<th>歌曲名</th>
											<th>序号</th>
											<th>排名</th>
											<th>歌曲名</th>
											<th>序号</th>
											<th>排名</th>
											<th>歌曲名</th>
										</tr>
										<tr class="success">
											<td>1</td>
											<td>张三成功</td>
											<td>13</td>
											<td>1</td>
											<td>张三成功</td>
											<td>13</td>
											<td>1</td>
											<td>张三成功</td>
											<td>13</td>
											<td>1</td>
											<td>张三成功</td>
											<td>13</td>
											<td>1</td>
											<td>张三成功</td>
											<td>13</td>
										</tr>
										<tr class="danger">
											<td>2</td>
											<td>李四danger</td>
											<td>13</td>
											<td>2</td>
											<td>李四danger</td>
											<td>13</td>
											<td>2</td>
											<td>李四danger</td>
											<td>13</td>
											<td>2</td>
											<td>李四danger</td>
											<td>13</td>
											<td>2</td>
											<td>李四danger</td>
											<td>13</td>
										</tr>
										<tr>
											<td>3</td>
											<td>王五</td>
											<td>13</td>
											<td>3</td>
											<td>王五</td>
											<td>13</td>
											<td>3</td>
											<td>王五</td>
											<td>13</td>
											<td>3</td>
											<td>王五</td>
											<td>13</td>
											<td>3</td>
											<td>王五</td>
											<td>13</td>
										</tr>
										<tr>
											<td>4</td>
											<td>赵六</td>
											<td>13</td>
											<td>4</td>
											<td>赵六</td>
											<td>13</td>
											<td>4</td>
											<td>赵六</td>
											<td>13</td>
											<td>4</td>
											<td>赵六</td>
											<td>13</td>
											<td>4</td>
											<td>赵六</td>
											<td>13</td>
										</tr>
									</tbody>
								</table>
							</div>
							<p class="lead">
								4.3表单优化设计 <br>表单 基本实例 单独的表单控件会被自动赋予一些全局样式。所有设置了
								.form-control 类的 input>、 textarea> 和 select> 元素都将被默认设置宽度属性为
								width: 100%;。 将 label 元素和前面提到的控件包裹在 .form-group 中可以获得最好的排列。

							</p>
							<div>
								<form>
									姓名:<input type="text" placeholder="请输入">
									<div class="form-inline">
										<div class="form-group">
											<label for="exampleInputEmail1">Email address</label> <input
												type="email" class="form-control" id="exampleInputEmail1"
												placeholder="Enter email">
										</div>
										<div class="form-group">
											<label>学校:</label> <input type="text" class="form-control"
												placeholder="请输入学校">
										</div>
									</div>
									<div>内联表单 为 form>元素添加 .form-inline 类可使其内容左对齐并且表现为
										inline-block 级别的控件。只适用于视口（viewport）至少在 768px
										宽度时（视口宽度再小的话就会使表单折叠）。</div>
									<div class="form-group">
										<label class="sr-only" for="exampleInputEmail2">Email
											address</label> <input type="email" class="form-control"
											id="exampleInputEmail2" placeholder="Enter email">
									</div>
									<div class="form-group">
										<div class="input-group">
											<div class="input-group-addon">@</div>
											<input class="form-control" type="email"
												placeholder="Enter email">
										</div>
									</div>
									<div class="form-group">
										<label class="sr-only" for="exampleInputPassword2">Password</label>
										<input type="password" class="form-control"
											id="exampleInputPassword2" placeholder="Password">
									</div>
									<div class="checkbox">
										<label> <input type="checkbox"> Remember me
										</label>
									</div>
									<div>文本域 支持多行文本的表单控件。可根据需要改变 rows 属性。</div>
									<textarea class="form-control" rows="3"></textarea>
									<div class="form-group has-error has-feedback">
										<label class="control-label" for="inputError2">Input
											with error</label> <input type="text" class="form-control"
											id="inputError2"> <span
											class="glyphicon glyphicon-remove form-control-feedback"></span>
									</div>
									<div>控件尺寸 通过 .input-lg 类似的类可以为控件设置高度，通过 .col-lg-*
										类似的类可以为控件设置宽度。 高度尺寸 创建大一些或小一些的表单控件以匹配按钮尺寸。</div>
									<input class="form-control input-lg" type="text"
										placeholder=".input-lg"> <input class="form-control"
										type="text" placeholder="Default input"> <input
										class="form-control input-sm" type="text"
										placeholder=".input-sm"> <select
										class="form-control input-lg">
									</select> <select class="form-control">
									</select> <select class="form-control input-sm">
									</select>
									<div>
										调整列（column）尺寸 用栅格系统中的列（column）包裹输入框或其任何父元素，都可很容易的为其设置宽度。


										.col-xs-2 .col-xs-3 .col-xs-4 Copy
										<div class="row">
											<div class="col-xs-2">
												<input type="text" class="form-control"
													placeholder=".col-xs-2">
											</div>
											<div class="col-xs-3">
												<input type="text" class="form-control"
													placeholder=".col-xs-3">
											</div>
											<div class="col-xs-4">
												<input type="text" class="form-control"
													placeholder=".col-xs-4">
											</div>
										</div>
									</div>
									<div>按钮 预定义样式 使用下面列出的类可以快速创建一个带有预定义样式的按钮。</div>
									<div>
										<!-- Standard button -->
										<button type="button" class="btn btn-default btn-lg">Default</button>

										<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
										<button type="button" class="btn btn-primary">Primary</button>

										<!-- Indicates a successful or positive action -->
										<button type="button" class="btn btn-success">Success</button>

										<!-- Contextual button for informational alert messages -->
										<button type="button" class="btn btn-info">Info</button>

										<!-- Indicates caution should be taken with this action -->
										<button type="button" class="btn btn-warning">Warning</button>

										<!-- Indicates a dangerous or potentially negative action -->
										<button type="button" class="btn btn-danger">Danger</button>

										<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
										<button type="button" class="btn btn-link">Link</button>
									</div>
									<div>
										<div class="well"
											style="max-width: 400px; margin: 0 auto 10px;">
											<button type="button"
												class="btn btn-primary btn-lg btn-block">Block
												level button</button>
											<button type="button"
												class="btn btn-default btn-lg btn-block">Block
												level button</button>
										</div>

									</div>
								</form>
								<p class="title">4.5图片和图标设计,dao 135</p>
								<p>图片 响应式图片 在 Bootstrap 版本 3 中，通过为图片添加 .img-responsive
									类可以让图片支持响应式布局。其实质是为图片设置了 max-width: 100%; 和 height: auto;
									属性，从而让图片在其父元素中更好的缩放。</p>
								<div>
									<img src="<%=BasePath%>/image/t1.jpg"
										class="img-responsive img-rounded" alt="Responsive image">
									<br> 图片形状 通过为 <img> 元素添加以下相应的类，可以让图片呈现不同的形状。 跨浏览器兼容性
									请时刻牢记：Internet Explorer 8 不支持 CSS3 中的圆角属性。 140x140 140x140
									140x140 Copy 'img src="..." alt="..." class="img-rounded">'
									'img src="..." alt="..." class="img-circle">' 'img src="..."
									alt="..." class="img-thumbnail">
									<div class="col-xs-10">
										<img src="<%=BasePath%>/image/t2.jpg"
											class="img-responsive img-thumbnail" alt="Responsive image">
									</div>
									<img src="<%=BasePath%>/image/t3.jpg"
										class="img-responsive img-circle" alt="Responsive image">

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="profile">
				<h4 class="title">第5章：less 140</h4>
				<div class="container-fluid">
					<p>5.1.3less参考和工具：1.在线编译工具：less官网或http://tool.oschina.net/less,2.本地编译工具simpleless，winless</p>
					<p>5.4LESS动态语法:dao 159</p>
					<ol>
						<li>5.4.1:变量：@开头，写法和css一样,如:@color:red; <pre>
						less:
						@font-color:red;
						.c1{
							color:@font-color;
						  	font-size:1em;
						}
	
						</pre> <pre>
						css:
						.c1 {
						  color: #ff0000;
						  font-size: 1em;
						}
						</pre>
							<div class="c1">c1样式</div>
						</li>
						<li>5.4.2混合：公共样式混合继承: <pre>.border{
								border-top:1px dotted #333;
							}
							.c2{
								.border;
							  	background-color:blue;
							}
							.c3{
								.border;
							    background-color:yellow;
							}</pre>
							<div class="c2">c2555</div>
							<div class="c3">c3333</div> 设置参数的混合： <pre>
								.border(@pa:1px){
								    border-top:@pa dotted #333;
								}
								.c2{
								    .border;
								    background-color:blue;
								}
								.c3{
								    .border(3px);
								    background-color:yellow;
								}
							</pre>
						</li>
						<li>5.4.4参数混合,模式匹配，类似重载</li>
						<li>.border-set(@top:3px,@bottom:2px,@left:3px){
							border-top:@top; border-bottom:@bottom; border-left:@left; }
							.table{ .border-set; } <pre>
								.reload(@a){
									 color:@a;
									}
									.reload(@a:blue,@b:3px){
									  color:@a;
									  width:@b;
									}
									.r1{
									 .reload(blue);
									  
									}
									.r2{
										.reload(green,5px);
									}
							</pre>
						</li>
						<li>5.4.5条件表达式:dao 166</li>
						<li>when<pre>
							.when1(@con) when (@con>=5){
								color:yellow;
							}
							.when1(@con) when (@con<5){
							  	color:blue;
							}
							.w1{
							 .when1(6);
							}
							.w2{
							.when1(3);
							}
						</pre> 常见的检测函数: <pre>
							.when1(@con) when (iscolor(@con)){
								color:@con;
							}
							.when1(@con) when (isnumber(@con)){
							  	width:@con;
							}
							.w1{
							 .when1(6);
							}
							.w2{
							.when1(blue);
							}
						</pre> 还可使用and or(用,号) not
						</li>
						<li>5.4.6嵌套规则: 样式下面多个子样式： <pre>
							.imgall{
							  width:auto;
							  span{
							    border-size:3px;
							  }
							  p{
							  	font-size:2em;
							  }
							}
						</pre> 串联选择器用& <pre>
						.imgall{
							  width:auto;
							  span{
							    border-size:3px;
							  }
							  p{
							  	font-size:2em;
							  }
							  &.imgc1{
							    height:auto;
							  }
							}
						</pre> 生成的css代码如下： <pre>
							.imgall {
							  width: auto;
							}
							.imgall span {
							  border-size: 3px;
							}
							.imgall p {
							  font-size: 2em;
							}
							.imgall.imgc1 {
							  height: auto;
							}
						</pre>
						</li>
						<li>5.4.7运算,5.4.8颜色函数,5.4.9数学函数</li>
						<li>5.4.11命名空间防止冲突 <pre>#ns1{
								  .col{
								  	color:blue;
								  }
								  @fs:3px;
								  .font{
								  	font-size:@fs;
								  }
								}
								.nst1{
									#ns1.font;
								}</pre>
						</li>
						<li>5.4.12注释：/**/ <br>5.4.13导入@import "lib1.less" <br>字符串插值:<pre>
						@basurl:"www.timobb.com";
						.url1{
						  background-img:url("@{baseurl}/a/1.png");
						}
						</pre>
						</li>
					</ol>
				</div>
			</div>
			<div class="tab-pane fade  active in" id="messages">
				<h4 class="title">第6章：使用bootstrap组件:dao 187</h4>
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