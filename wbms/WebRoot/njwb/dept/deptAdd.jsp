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

		<title>My JSP 'deptadd.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/reset.css">
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
		<style type="text/css">
body,div,table,tr,td {
	margin: 0px;
	padding: 0px;
}

#deptEditTable {
	font-size: 15px;
	border-collapse: collapse;
	width: 350px;
	margin: 20px auto;
}

#deptEditTable td {
	height: 40px;
}
</style>
	</head>
	<body>
		<form action="deptAdd.action">

			<table id="deptEditTable">
				<tr>
					<td>
						部门编号:
					</td>
					<td>
						<input type="text" name="deptNo" id="deptNo"  />
					</td>
				</tr>
				<tr>
					<td>
						部门名称:
					</td>
					<td>
						<input type="text" name="deptName" id="deptName" />
					</td>
				</tr>
<%--				<tr>--%>
<%--					<td>--%>
<%--						部门位置:--%>
<%--					</td>--%>
<%--					<td>--%>
<%--						<input type="text" name="deptLoc" id="deptLoc" />--%>
<%--					</td>--%>
<%--				</tr>--%>
				<tr>
					<td colspan="2">
						<input type="submit" value="添加" />
						<input type="reset" value="重置" />
						<a href="dept.html" target="contentPage"><input type="button"
								value="返回"> </a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>