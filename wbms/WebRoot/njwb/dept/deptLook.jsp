<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

		<title>My JSP 'deptLook.jsp' starting page</title>

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
		<form action="deptModify.action">

			<table id="deptEditTable">
				<tr>
					<td>
						部门编号:
					</td>
					<td>
						<input type="text" readonly name="deptNo" id="deptNo"
							value="${dept.deptNo}" />
						不可修改
					</td>
				</tr>
				<tr>
					<td>
						部门名称:
					</td>
					<td>
						<input type="text" name="deptName" id="deptName"
							value="${dept.deptName}" />
					</td>
				</tr>
				<tr>
<%-- 				${empList}--%>
					<td>
						部门经理:
					</td>
					<td>
						<select name="deptManEmpNo" id="deptManEmpNo">
							<c:forEach items="${empList}" var="emp">
								<option name="deptManEmpNo" value="${emp.empNo }" <c:if test="${emp.empNo eq dept.deptManEmpNo}"> selected</c:if> >
									${emp.empNo } ${emp.empName }
								</option>
							</c:forEach>
						</select>
					</td>



					<%--					<td>--%>
					<%--						<input type="text" name="deptManEmpNo" id="deptManEmpNo"  value = "${dept.deptManEmpNo}${dept.deptManEmpName}" />--%>
					<%--					</td>--%>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="修改" />
						<input type="reset" value="重置" />
						<a href="dept.html" target="contentPage"><input type="button"
								value="返回"> </a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
