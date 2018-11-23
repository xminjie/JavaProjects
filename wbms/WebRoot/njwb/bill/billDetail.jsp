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
		
		
<%--$(function(){--%>
<%--	--%>
<%--	--%>
<%--	$.ajax( {--%>
<%--		url : "depts.action",--%>
<%--		dataType : "text",--%>
<%--		success : function(result) {--%>
<%--			if (result == "success") {--%>
<%--				alert("添加成功！");--%>
<%--				window.location.href = "showEmp.action";--%>
<%--			}--%>
<%--		}--%>
<%--	});--%>
<%--	--%>
<%--	--%>
<%--	--%>
<%--	--%>
<%--	--%>
<%--});--%>
<%--		--%>
		
 
</script>
	</head>

	<body onload="Date();">
		<h1 class="title">
			报销账单添修改
			</h1>
			${bill}
<%--			<c:if test="${loginUser.account != 'root'}">--%>
			<form action="billModify.action" method="post">

				<table id="empEditTable">
					<tr>
						<td>
						<input  type="hidden" name = "empNo" value="${loginUser.account}">
						<input type="hidden" name = "billNo" value="${bill.billNo}">
							当前账单编号: B${bill.billNo}
						</td>
						<td>
							 
						</td>
					</tr>				
 
					<tr>
						<td>
							报销类型:
						</td>
						<td>
							<select readonly name="billType" id="billType">
									<option name="billType" value="1" ${bill.billType eq 1 ? "selected" : ""} >
										差旅费
									</option>
									<option name="billType" value="2" ${bill.billType eq 2 ? "selected" : ""}>
										招待费	
									</option>
									<option name="billType" value="3" ${bill.billType eq 3 ? "selected" : ""}> 
										办公费
									</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							金额
						</td>
						<td>
							<input readonly type="text" name="billCnt" id="billCnt" value = "${bill.billCnt}" />
						</td>
					</tr>
					<tr>
						<td>
							申请时间:
						</td>
						<td>
							<input readonly type="text" name="billTime" id="billTime" value = "${bill.billTime}"  />
						</td>
					</tr>
					<tr>
						<td>
							详细说明:
						</td>
						<td>
							<textarea rows="5" cols="40" name="billDetail" readonly  >${bill.billDetail}</textarea>
						</td>
					</tr>
					<tr>
					<tr>
						<td>
							提交选项:
						</td>
						<td>
							草稿<input readonly type="radio"  name = "billStatus"  value = "-1" ${bill.billStatus eq -1 ? "checked" : ""}><br>
							正式提交<input type="radio"  name = "billStatus"  value = "1" ${bill.billStatus eq 1 ? "checked" : ""}>
						</td>
					</tr>
					<tr>
					
						<td colspan="2">
							
							<a href="bills.action" target="contentPage"><input
									type="button" value="返回">
							</a>
						</td>
					</tr>
					
				</table>
			</form>
<%--			</c:if>--%>
	</body>
</html>