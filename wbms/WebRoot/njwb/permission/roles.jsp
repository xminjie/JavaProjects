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
		
		 function del(roleId){
				
				window.location="roleDelete.action" + "?roleId="+ roleId ;
								
		}
		 
		 function roleLook(roleId){
				
				window.location="roleLook.action" + "?roleId="+ roleId ;
								
		}
		
		 
	
	</script>
  </head>
  
  <body>
         	<h1 class="title">首页  &gt;&gt;角色管理 </h1>
          	<div class="add">
          	<form action= "roleAdd.action" method="post">
          		<input type="submit"   value="添加角色" />&nbsp 
          		<input type="text"  name="roleName" />   
          		
<%--         		<a href="roleAddd.action" target="contentPage"><img alt="" src="img/add.png" width="18px" height="18px">添加角色</a>--%>
         	</form>
         		
         	</div>
<%--         	${roleList}--%>
         	<table class="deptInfo">
         		<tr class="titleRow">
       				<td>角色id</td>
       				<td>角色名称</td>
         			<td>操作列表</td>
         		</tr>
          		<c:forEach items="${roleList}" var = "role">
         			<tr class="titleRow">
         				<td>${role.roleId}</td>
         				<td>${role.roleName}  </td>
         				<td>
         				<img alt="" src="img/delete.png" class="operateImg" onclick="del(${role.roleId})">
         				<a href="javascript:; target="contentPage"  onclick="roleLook('${role.roleId}')"><img alt="" src="img/edit.png" class="operateImg" ></a>
         				</td>
         			</tr>
         		</c:forEach>
         	</table>
  </body>
</html>
