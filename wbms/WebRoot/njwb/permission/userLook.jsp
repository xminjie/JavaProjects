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
    
    <title>My JSP 'userLook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

  </head>
  
  <body>
<%--    ${roleList } --%>
<%--    ${user }--%>
    
    <table class="deptInfo">
         		<tr class="titleRow">
       				<td>用户账户</td>
       				<td>用户名称</td>
         			<td>用户状态</td>
         			<td>用户角色</td>
         			<td>操作列表</td>
         			 
         		</tr>
         		
         		<tr class="titleRow">
       				<form action="userModify.action">
       					<input type="hidden" name = "account" value="${user.account }">
       					<td>${user.account }</td>
       					<td>${user.name }</td>
         				<td>${user.status eq 1 ? "正常":"禁用"  }</td>
         				<td>
         					 <select name = "roleId">
         					 	<c:forEach items="${roleList}" var = "role">
         					 		<option value="${role.roleId }"
         					 		${user.roleId eq role.roleId ? "selected" : "" }
         					 		 > ${role.roleId }-- ${role.roleName }</option>
         						 </c:forEach>
         				 	</select>
         				</td>
         				<td><input type="submit" value="确认修改角色"></td>
         			</form>
         			 
         		</tr>
    </table>
  </body>
</html>
