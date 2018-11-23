<%@page import="com.njwb.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  ${testApp }<br>
    el表达式取值 <br>
    <%
    	//设置值
    	pageContext.setAttribute("userName", "pageContext:赵丽颖");
    	request.setAttribute("userName", "request:赵丽颖");
    	session.setAttribute("userName", "session:赵丽颖");
    	application.setAttribute("userName", "application:赵丽颖");
    	
    	request.setAttribute("age", 20);
    	
    	//2.自定义对象类型
    	User user = new User();
    	user.setId(2);

    	
    	//数组
    	String[] names = {"刘长荣","安博","毛永旺"};
    	request.setAttribute("names", names);
    	
    	//List
    	User user1 = new User();
    
    	
    	List<User> userList = new ArrayList<User>();
    
    	request.setAttribute("userList1234", userList);
    	
    	//Map
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("userName", "田蔚荻");
    	map.put("age",18);
    	
    	request.setAttribute("paramMap", map);
    	
     %>
    
    
    <br>
    el取值:<br>
           userName:${userName }<br>
           age:${ age}<br>
    取指定范围的值: ${requestScope.userName },${applicationScope.userName }<br>
     自定义对象:${user.userAccount },${user.name } 
     <br>
     数组:${names[2] }<br>
  List: ${userList1234[2].userAccount }<br>
  
  Map:${paramMap.userName },${paramMap["age"] },${paramMap.mapUser.userAccount }
  
  <br>
  el进行运算<br>
  算术运算符:${2 + 3 },${paramMap.age},${paramMap.age + 10 }<br>
 比较运算符:${paramMap.age > 16 },${paramMap.age < 16 }<br>
 	    ${paramMap.age gt 16 },${paramMap.age lt 16 }<br>
 	    ${paramMap.age > age }<br>
转义字符: gt lt ge le eq  <br>
逻辑运算符:${paramMap.age > 16 && paramMap.age < age}<br>
		${paramMap.age > 16 and paramMap.age < age}<br>
转义字符: and   or 
三元表达式 :<br>年龄:${paramMap.age },${paramMap.age < 30 ? "小鲜肉" : "老腊肉" }

<br>
jstl标签库,配合el取值<br>

<!-- c:if标签,test的结果就是一个boolean值 -->
<%-- <c:if test="${age > 30}">老腊肉</c:if> --%>
<c:if test="${age < 30 && age > 16 }">小鲜肉</c:if>
<!-- 
	for(String name : names)
	{
		System.out.println(name);
	}
 -->
 <br>
 <!-- 
 	items: 需要循环的集合对象
 	var: 用来接收每次循环,从集合中取出的对象的变量
 	begin: 开始位置,下标从0开始
 	end:结束位置,下标从0开始
 	step: 步长,每次循环跳几个
  -->
  
  <%-- jsp中的注释,tomcat不会翻译,不会输出到浏览器 --%>
 <c:forEach items="${names }" var="name">
 	<span>${name },</span>
 
 </c:forEach> 
 	   
  
  </body>
</html>
