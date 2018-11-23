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
		
		 function del(billNo){
				
				window.location="billDelete.action" + "?billNo="+ billNo ;
								
		}
		 
		 function billLook(billNo){
				window.location="billLook.action" + "?billNo="+ billNo ;	
		}
		 
		 function billDetail(billNo){
				window.location="billDetail.action" + "?billNo="+ billNo ;	
		}
		
		 
	
	</script>
  </head>
  
  <body>
         	<h1 class="title">首页  &gt;&gt;报销管理 </h1>
<%--         	${billList}--%>
          	<div class="add">
          	<c:if test="${loginUser.account != 'root'}">
         		<a href="/wbms/njwb/bill/billShowAdd.jsp" target="contentPage"><img alt="" src="img/add.png" width="18px" height="18px">添加报销账单</a>
         	</c:if>
         	</div>
         	<table class="deptInfo">
         		<tr class="titleRow">
       				<td>报销编号</td>
         			<td>报销部门</td>
         			<td>报销人</td>
         			<td>类型</td>
         			<td>金额</td>
         			<td>申请时间</td>
         			<td>状态</td>
         			<td>操作列表</td>
         			
         		</tr>
          		<c:forEach items="${billList}" var = "bill">
         			<tr class="titleRow">
         				<td>B${bill.billNo}</td>
       					<td>${bill.billDeptNo}-${bill.billDeptName}</td>
        	 			<td>${bill.billEmpNo}-${bill.billEmpName}</td>
         				<td>   
         				<c:if test="${bill.billType eq 1}"> 差旅费</c:if>
         				<c:if test="${bill.billType eq 2}"> 招待费</c:if> 
         				<c:if test="${bill.billType eq 3}"> 办公费</c:if>   </td>
         				<td>${bill.billCnt}</td>
         				<td>${bill.billTime}</td>
         				<td>${bill.billStatus eq -1 ? "草稿":"已提交"}</td>
         				<td>
         				<c:if test="${bill.billStatus eq -1}">
         						<c:if test="${bill.billEmpNo eq loginUser.account}">
         						<img alt="" src="img/delete.png" class="operateImg" onclick="del('${bill.billNo}')">
         						<img alt="" src="img/edit.png" class="operateImg" onclick="billLook('${bill.billNo}')">
         						
         					</c:if>
         				</c:if>
         				<img alt="详细"   class="operateImg" src="img/detail.png" onclick="billDetail('${bill.billNo}')">
         				</td>
         			</tr>
         		</c:forEach>
         	</table>
  </body>
</html>
