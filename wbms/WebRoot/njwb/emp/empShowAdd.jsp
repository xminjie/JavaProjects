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

		<title>My JSP 'empAdd.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript" src="js/jquery-1.8.3.min.js">
</script>
		<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
		<style type="text/css">
body,div,table,tr,td {
	margin: 0px;
	padding: 0px;
}

#empEditTable {
	font-size: 15px;
	border-collapse: collapse;
	width: 350px;
	margin: 20px auto;
}

#empEditTable td {
	height: 40px;
}
</style>

		<script type="text/javascript">
		
		
$(function(){
	
	
	$.ajax( {
		url : "depts.action",
		dataType : "text",
		success : function(result) {
			if (result == "success") {
				alert("添加成功！");
				window.location.href = "showEmp.action";
			}
		}
	});
	
	
	
	
	
});
		
		
		
		 
<%----%>
<%--}--%>
</script>
	</head>

	<body onload="Date();">
		<h1 class="title">
			员工添加
			</h>
			<form action="empAdd.action" method="post">

				<table id="empEditTable">
					<tr>
						<td>
							员工编号:
						</td>
						<td>
							<input type="text" name="empNo" id="empNo" />
						</td>
					</tr>
					<tr>
						<td>
							员工姓名:
						</td>
						<td>
							<input type="text" name="empName" id="empName" />
						</td>
					</tr>

					<tr>
						<td>
							性别:
						</td>
						<td>
						
						<input type="radio"  name ="empSex" value="-1"> 女 
						<input type="radio"name ="empSex"  value="1"> 男
						</td>
					</tr>
					<tr>
						<td>
							所属部门:
						</td>
						<td>
							<select name="empDeptNo" id="empDeptNo">
								<c:forEach items="${deptList }" var="dept">
									<option name="empDeptNo" value="${dept.deptNo }">
										${dept.deptNo } ${dept.deptName }
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							邮箱:
						</td>
						<td>
							<input type="text" name="empEmail" id="empEmail" />
						</td>
					</tr>
					<tr>
						<td>
							学历:
						</td>
						<td>
							<input type="text" name="empEdu" id="empEdu" />
						</td>
					</tr>
					<tr>
						<td>
							电话:
						</td>
						<td>
							<input type="text" name="empPhone" id="empPhone" />
						</td>
					</tr>

					<tr>
						<td>
							入职时间:
						</td>
						<td>
							<input type="text" id="entryTime" name="entryTime" value="" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="添加"  />
							<input type="reset" value="重置" />
							<a href="emps.action" target="contentPage"><input
									type="button" value="返回">
							</a>
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>