<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'emps.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

    
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

	<style type="text/css">
	
	
	</style>
	
	<script type="text/javascript">
		
		function del(empNo){
			if(window.confirm("确认要删除吗?")){
				
				window.location="empDelete.action" + "?empNo="+ empNo ;
				
				alert("删除成功");
				
			}
		}
		
		function look(empNo){
				
				window.location="empLook.action" + "?empNo="+ empNo ;
								
		}
	
	</script>
  </head>
  
  <body>
         	<h1 class="title">首页  &gt;&gt;员工管理 </h1>
         	<div class="add">
         		<a href="empShowAdd.action" ><img alt="" src="img/add.png" width="18px" height="18px">添加员工</a>
         	</div>
         	<table class="deptInfo">
         		<tr class="titleRow">
       				<td>员工编号</td>
       				<td>员工名称</td>
         			<td>员工部门编号</td>
         			<td>员工部门名称</td>
         			<td>操作列表</td>
         		</tr>
          		<c:forEach items="${empList}" var = "emp">
         			<tr class="titleRow">
         				<td>${emp.empNo}</td>
         				<td>${emp.empName}</td>
         				<td>${emp.empDeptNo}</td>
         				<td>${emp.empDeptName}</td>
         				<td>
         				<img alt="" src="img/delete.png" class="operateImg" onclick="del('${emp.empNo}')">
         				<a href="javascript:; target="contentPage"  onclick="look('${emp.empNo}')"><img alt="" src="img/edit.png" class="operateImg" ></a>
         				<a href="empDetail.html" target="contentPage"><img alt="" src="img/detail.png" class="operateImg"></a>
         				</td>
         			</tr>
         		</c:forEach>
         	</table>
  </body>
</html>
