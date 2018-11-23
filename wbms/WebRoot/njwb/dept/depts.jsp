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
    
    <title>My JSP 'dept.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>部门管理</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

	<style type="text/css">
	
	
	</style>
	
	<script type="text/javascript">
		
		function del(deptNo){
			if(window.confirm("确认要删除吗?")){
				
				window.location="deptDelete.action" + "?deptNo="+ deptNo ;
				
				alert("删除成功");
				
			}
		}
		
		function look(deptNo){
				
				window.location="deptLook.action" + "?deptNo="+ deptNo ;
								
		}
	
	</script>
  </head>
  
  <body>
         	<h1 class="title">首页  &gt;&gt;部门管理 </h1>
         	<div class="add">
         		<a href="njwb/dept/deptAdd.jsp" target="contentPage"><img alt="" src="img/add.png" width="18px" height="18px">添加部门</a>
         	</div>
         	<table class="deptInfo">
         		<tr class="titleRow">
       				<td>部门编号</td>
       				<td>部门名称</td>
         			<td>部门负责人工号</td>
         			<td>部门负责人</td>
         			<td>部门人数</td>
         			<td>操作列表</td>
         		</tr>
         		<c:forEach items="${deptList}" var = "dept">
         			<tr class="titleRow">
         				<td>${dept.deptNo}</td>
         				<td>${dept.deptName}</td>
         				<td>${dept.deptManEmpNo}</td>
         				<td>${dept.deptManEmpName}</td>
         				<td>${dept.deptEmpCnt}</td>
         				<td>
         				<c:if test="${dept.deptEmpCnt eq 0}">
         				<img alt="" src="img/delete.png" class="operateImg" onclick="del('${dept.deptNo}')">
         				</c:if>
         				<a href="javascript:; target="contentPage"  onclick="look('${dept.deptNo}')"><img alt="" src="img/edit.png" class="operateImg" ></a>
         				<a href="deptDetail.html" target="contentPage"><img alt="" src="img/detail.png" class="operateImg"></a>
         			</td>
         			</tr>
         		</c:forEach>
         	</table>
  </body>
</html>