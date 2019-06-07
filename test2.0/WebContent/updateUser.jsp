<%@page import="com.taihu.model.Users"%>
<%@page import="com.taihu.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String suid = request.getParameter("uid");
   
    int uid=0;
	if (suid != null){
		 uid = Integer.parseInt(suid);
	}
	UsersDao userDao = new UsersDao();
	Users user = userDao.getUserById(uid);
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
    text-align: center;
} 
</style>
</head>
<body>
	<h1>修改用户信息</h1>
	<form action="updateuser" method="post">
		用户ID： <input type="text" name="uid" value="<%=user.getUid()%>"
			readonly="readonly"><br> 用户名称：<input type="text"
			name="username" value="<%=user.getUsername()%>"><br>
		用户密码：<input type="text" name="userpasswd"
			value="<%=user.getUserpasswd()%>"><br> 用户性别：<input
			type="text" name="gender" value="<%=user.getGender()%>"><br>
		<input type="submit" value="修改"> <input type="reset"
			value="取消">


	</form>
</body>
</html>