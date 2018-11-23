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
		
		 
		
		function able(account){
				
				window.location="able.action" + "?account="+ account ;
								
		}
		
		function showUserChangeRole(account){
				
				window.location="userLook.action" + "?account="+ account ;
								
		}
		
	
	</script>
  </head>
  
  <body>
         	<h1 class="title">首页  &gt;&gt;用户管理 </h1>
          	<div class="add">
         		<a href="empShowAdd.action" target="contentPage"><img alt="" src="img/add.png" width="18px" height="18px">添加员工</a>
         	</div>
<%--         	${userList}--%>
         	<table class="deptInfo">
         		<tr class="titleRow">
       				<td>账户</td>
       				<td>名称</td>
       				<td>角色</td>
       				<td>状态</td>
         			<td>操作列表</td>
         		</tr>
          		<c:forEach items="${userList}" var = "user">
         			<tr class="titleRow">
         				<td>${user.account}</td>
         				<td>${user.name}  </td>
         				<td>${user.roleName}  </td>
         				<td>${user.status == 1 ? "正常":"禁用"}  </td>

         				<td>
          				<a href="javascript:; target="contentPage"  onclick="able('${user.account}')">禁用/恢复</a>
          				--
          				<a href="javascript:; target="contentPage"  onclick="showUserChangeRole('${user.account}')">更改角色</a>
          			</td>
         			</tr>
         		</c:forEach>
         	</table>
  </body>
</html>
