<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'login.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title>用户登录</title>
		<link rel="stylesheet" href=css/login.css " type="text/css"></link>
		<link rel="stylesheet" href="css/reset.css" type="text/css"></link>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>

<script type="text/javascript">
	$(function(){
		if(window.parent.length > 0){
			window.parent.location = "login.action";
		}
	});



</script>



	</head>

	<style type="text/css">
body {
	background-color: #0070A2;
}
</style>


	<body>
		<div id="login">
			<div id="title">
				NJWB管理系统
			</div>
			<form action="login.action" method="post">
				<table id="loginTable">
					<tr>
						<td>
							用户名:&nbsp;
						</td>
						<td>
							<input type="text" name="account" id="userName" />
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							密&nbsp;&nbsp;&nbsp;码:&nbsp;
						</td>
						<td>
							<input type="password" name="passwd" id="password" />
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							验证码:&nbsp;
						</td>
						<td>
							<input type="text" name="code" id="code" />
						</td>
						<td>
						
							&nbsp;
							<img alt="验证码图片" src="checkCode.action" title="点击换一张">
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td colspan="2">
							<input type="submit" value="登&nbsp;录" class="btn" />
						</td>
					</tr>

				</table>
			</form>
		</div>
	</body>
</html>