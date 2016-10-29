<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String BasePath = request.getServletContext().getContextPath();
%>
<!--navigation  -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header nav-space-left">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Yfairy</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group input-group">
					<input type="text" class="form-control" placeholder="Search">
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-search"></span></span>
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=BasePath%>/login/toLoginPage">Login</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">账户 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Account</a></li>
						<li class="divider"></li>
						<li><a href="#">Settings</a></li>
						<li><a href="#">Logout</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>
