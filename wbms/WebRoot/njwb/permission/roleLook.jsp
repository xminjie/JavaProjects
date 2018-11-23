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
    
    <title>My JSP 'roleLook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	 

    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
 
<%--   <script type="text/javascript">--%>
<%--   	$(function(){--%>
<%--   		//全选/取消效果--%>
<%--   		levelOne();--%>
<%--   		levelTwo();--%>
<%--   	});--%>
<%--   	--%>
<%--   	//一级菜单checkbox绑定全选/取消--%>
<%--   	function levelOne()--%>
<%--   	{--%>
<%--   		$("span>input[type='checkbox']").click(function(){--%>
<%--   			//alert(123);--%>
<%--   			//alert($(this).attr("checked"));--%>
<%--   			if($(this).attr("checked") == "checked")--%>
<%--   			{--%>
<%--   				$(this).parent().siblings().find(":checkbox").attr("checked",$(this).attr("checked"));--%>
<%--   			}--%>
<%--   			else--%>
<%--   			{--%>
<%--   				$(this).parent().siblings().find(":checkbox").removeAttr("checked");--%>
<%--   			}--%>
<%--   			--%>
<%--   		});--%>
<%--   	}--%>
<%--   	--%>
<%--   	//二级菜单checkbox绑定全选/取消--%>
<%--   	function levelTwo()--%>
<%--   	{--%>
<%--   		//$("input[name='checkedMenu']")--%>
<%--   		$("li[class='menu-sub']>input[type='checkbox']").click(function(){--%>
<%--   			//--%>
<%--   			var checkboxNum = $(this).parent().parent().find(":checkbox").length;--%>
<%--   			var checkedNum = $(this).parent().parent().find(":checkbox:checked").length;--%>
<%--   			if(checkboxNum == checkedNum)--%>
<%--   			{--%>
<%--   				$(this).parent().parent().prev().find(":checkbox").attr("checked","checked");--%>
<%--   			}--%>
<%--   			else--%>
<%--   			{--%>
<%--   				//checkbox->li---->ul---->span--->span下的checkbox--%>
<%--   				$(this).parent().parent().prev().find(":checkbox").removeAttr("checked");--%>
<%--   			}--%>
<%--   			--%>
<%--   		});--%>
<%--   	}--%>
<%--   	--%>
<%--   </script> --%>
    
   
  </head>
  
  <body>
  	<div id = "mainDiv">
	  	
	    <h1 class="title">首页  &gt;&gt;权限变更 </h1>
<%--	    ${role}--%>
	    <div id = "contentDiv">
	    	<div id = "content-left" class="lft">
	    	 当前角色: ${role.roleId} -- ${role.roleName} 
	    	 
	    	 
	    		 
	    		
	    		<form action="roleModify.action">
	
	    		<ul>
	    		
	    			<li >
	    				<span>人事管理</span>${role.accessMenu}
	    				<ul >
	    					<li class="menu-sub">部门管理<input value="11" name="checkedMenu" type="checkbox"   ${ role.accessMenu[11] eq 1 ? "checked" : "" } ></li>
	    					<li class="menu-sub">员工管理<input value="12" name="checkedMenu" type="checkbox"   ${ role.accessMenu[12] eq 1 ? "checked" : "" } ></li>
	    					<li class="menu-sub">请假管理<input value="13" name="checkedMenu" type="checkbox"   ${ role.accessMenu[13] eq 1 ? "checked" : "" } >
	    					</li>
	    				</ul>
	    			
	    			</li>
	    			
	    			<li class="menu">
	    				<span>财务管理</span>
	    				<ul >
	    					<li class="menu-sub">报销管理<input value="21" name="checkedMenu" type="checkbox"  ${ role.accessMenu[21] eq 1 ? "checked" : "" } ></li>
	    					<li class="menu-sub">报销统计<input value="22" name="checkedMenu" type="checkbox"  ${ role.accessMenu[22] eq 1 ? "checked" : "" }></li>
	    				</ul>
	    			
	    			</li>	    			
	    		    <li class="menu">
	    				<span>系统管理</span>
	    				<ul>
	    					<li class="menu-sub">账户维护<input value="31" name="checkedMenu" type="checkbox"  ${ role.accessMenu[31] eq 1 ? "checked" : "" } ></li>
	    					<li class="menu-sub">角色管理<input value="32" name="checkedMenu" type="checkbox"  ${ role.accessMenu[32] eq 1 ? "checked" : "" } ></li>
	    					<li class="menu-sub">权限管理<input value="33" name="checkedMenu" type="checkbox"  ${ role.accessMenu[33] eq 1 ? "checked" : "" } ></li>
	    					<li class="menu-sub">密码重置<input value="34" name="checkedMenu" type="checkbox"  ${ role.accessMenu[34] eq 1 ? "checked" : "" } ></li>
	    					<li class="menu-sub">系统退出<input value="35" name="checkedMenu" type="checkbox"  ${ role.accessMenu[35] eq 1 ? "checked" : "" } ></li>
	    				</ul>
	    			
	    			</li>

	    		</ul>
	    		<input type="hidden" name = "roleId" value="${role.roleId}">
	    		<input type = "submit" value="确认变更权限">
	    		<input type="reset" value="重置">
	    		<input type="button" value="返回">
	    		
	    		
	    		
	    		</form>
	    		
	    	</div>
	    	
	    	
	    </div>
	    
  	
  	</div>
   
  </body>
</html>
