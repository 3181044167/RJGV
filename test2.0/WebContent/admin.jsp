<%@page import="com.taihu.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.taihu.dao.*,com.taihu.model.*,java.util.*"%>
<%
    	ArrayList<Users> list = (ArrayList<Users>)request.getAttribute("userslist");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background: url(image/bg.jpg) no-repeat top left;
    background-size: cover;
    
} 
#container {
	width: 800px;
	height: 800px;
	margin: 0 auto;
}
</style>
</head>
<body id ="container">
	<a href="adminIndex.jsp">返回管理员首页</a>
	<table border="1">
		<tr>
			
			<td>用户名称</td>
			<td>密码</td>
			<td>性别</td>
			<td>操作</td>
		<tr>
			<%
		// 5处理执行的结果
		for(Users u:list){
			
		%>
		
		<tr>
			
			<td><%=u.getUsername() %></td>
			<td><%=u.getUserpasswd() %></td>
			<td><%=u.getGender() %></td>
			<td><a href="deleteusers.do?uid=<%=u.getUid()%>" style="color:black">删除</a>|
				<a href="deleteusers.do?uid=<%=u.getUid()%>" style="color:black">修改</a>
		<tr>
			<% 
		
		}
			
		%>
		
	</table>
</body>
</html>