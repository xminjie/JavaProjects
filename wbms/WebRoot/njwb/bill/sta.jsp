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
		
		
 
 
</script>
	</head>

	<body onload="Date();">
		<h1 class="title">
			报销统计
			</h1>
<%--			${staCond }<br>--%>
<%--			${staBillList}--%>
 			<form action="sta.action" method="post">

  						 自定义（不选默认非自定义） &nbsp&nbsp&nbsp&nbsp
						 是<input    type="radio" name="selfDefine"  ${staCond.selfDefine eq 1 ? "checked" : "" } value = "1" />&nbsp&nbsp
						 否<input type="radio" name="selfDefine"  ${staCond.selfDefine eq -1 ? "checked" : "" } values = "-1"/> <br>
						年份
							<select name = "year" >
								<option name = "year" value = "0" ${staCond.year eq 0 ? "selected" : "" }>全年 </option>
								<option name = "year" value = "2015" ${staCond.year eq 2015 ? "selected" : "" }> 2015</option>
								<option name = "year" value = "2016" ${staCond.year eq 2016 ? "selected" : "" }> 2016</option>
								<option name = "year" value = "2017" ${staCond.year eq 2017 ? "selected" : "" }> 2017</option>
								<option name = "year" value = "2018" ${staCond.year eq 2018 ? "selected" : "" }> 2018</option>
								<option name = "year" value = "2019" ${staCond.year eq 2019 ? "selected" : "" }> 2019</option>
								<option name = "year" value = "2020" ${staCond.year eq 2020 ? "selected" : "" }> 2020</option>
								<option name = "year" value = "2021" ${staCond.year eq 2021 ? "selected" : "" }> 2021</option>
								<option name = "year" value = "2022" ${staCond.year eq 2022 ? "selected" : "" }> 2022</option>
								<option name = "year" value = "2023" ${staCond.year eq 2023 ? "selected" : "" }> 2023</option>
								<option name = "year" value = "2024" ${staCond.year eq 2024 ? "selected" : "" }> 2024</option>
								<option name = "year" value = "2025" ${staCond.year eq 2025 ? "selected" : "" }> 2025</option>
								<option name = "year" value = "2026" ${staCond.year eq 2026 ? "selected" : "" }> 2026</option>
								<option name = "year" value = "2027" ${staCond.year eq 2027 ? "selected" : "" }> 2027</option>
								<option name = "year" value = "2028" ${staCond.year eq 2028 ? "selected" : "" }> 2028</option>
								<option name = "year" value = "2029" ${staCond.year eq 2029 ? "selected" : "" }> 2029</option>
								<option name = "year" value = "2030" ${staCond.year eq 2030 ? "selected" : "" }> 2030</option>
								
								 </select>
							  &nbsp&nbsp&nbsp&nbsp
					
							<select name = "seaMon" >
								<option name = "seaMon" value = "0" ${staCond.seaMon eq 0 ? "selected" : "" }>全部 </option>
								<option name = "seaMon" value = "1" ${staCond.seaMon eq 1 ? "selected" : "" } >季度</option>
								<option name = "seaMon" value = "2" ${staCond.seaMon eq 2 ? "selected" : "" }  >月份</option>
							</select><br>
 							 
					
					自定义开始时间<input type="text" name="dateStart" value="${staCond.dateStart.year + 1900}-${staCond.dateStart.month + 1}-${staCond.dateStart.date}" /><br>
					自定义结束时间<input type="text" name="dateEnd" value="${staCond.dateEnd.year + 1900}-${staCond.dateEnd.month + 1}-${staCond.dateEnd.date}" /><br>
					
					<input  type="submit" value="查询"></input>
					
					
					
		<table class="deptInfo">
         		<tr class="titleRow">
       				<td>部门编号</td>
       				<td>总和</td>
         			<td>春季</td>
         			<td>夏季</td>
         			<td>秋季</td>
         			<td>冬季</td>
         			<td>1-月</td>
         			<td>2-月</td>
         			<td>3-月</td>
         			<td>4-月</td>
         			<td>5-月</td>
         			<td>6-月</td>
         			<td>7-月</td>
         			<td>8-月</td>
         			<td>9-月</td>
         			<td>10-月</td>
         			<td>11-月</td>
         			<td>12-月</td>
         			
         			
         		</tr>
         		<c:forEach items="${staBillList}" var = "staBill">
         			<tr class="titleRow">
         				<td>${staBill.deptNo}-${staBill.deptName}</td>
         				<td>${staBill.sum}</td>
         				<td>${staBill.sum13}</td>
         				<td>${staBill.sum46}</td>
         				<td>${staBill.sum79}</td>
         				<td>${staBill.sum1012}</td>
         				<td>${staBill.sum1}</td>
         				<td>${staBill.sum2}</td>
         				<td>${staBill.sum3}</td>
         				<td>${staBill.sum4}</td>
         				<td>${staBill.sum5}</td>
         				<td>${staBill.sum6}</td>
         				<td>${staBill.sum7}</td>
         				<td>${staBill.sum8}</td>
         				<td>${staBill.sum9}</td>        
         				<td>${staBill.sum10}</td>
         				<td>${staBill.sum11}</td>
         				<td>${staBill.sum12}</td>
         				
         			</td>
         			</tr>
         		</c:forEach>
         	</table>
					
					
					
			</form>
	</body>
</html>