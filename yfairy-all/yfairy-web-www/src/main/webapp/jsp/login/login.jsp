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

	<!--body  -->
	<div class="container-fluid login-margin">
		<form role="form">
			<div class="form-group input-group">
				<span class="input-group-addon"><span
					class="glyphicon glyphicon-user"></span></span> <input type="text"
					class="form-control" placeholder="Username">
			</div>
			<div class="form-group input-group">
				<span class="input-group-addon"><span
					class="glyphicon glyphicon-lock"></span></span> <input type="password"
					class="form-control" placeholder="Password">
			</div>
			<div class="form-inline">
				<div class="checkbox">
					<label> <input type="checkbox">Remember&nbsp;&nbsp;me
					</label>
				</div>
				<button type="submit" class="btn btn-default"
					style="margin-left: 70%;">
					Login&nbsp;&nbsp;&nbsp;&nbsp;<span
						class="glyphicon glyphicon-arrow-right"></span>
				</button>
			</div>
		</form>

	</div>

	<jsp:include page="/js.jsp"></jsp:include>
</body>
</html>