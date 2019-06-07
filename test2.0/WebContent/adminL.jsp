<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
		String error = request.getParameter("error");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#container {
	
	width: 250px;
	height: 300px;
	margin: 0 auto;
}
body{
	background: url(image/bg.jpg) no-repeat top left;
    background-size: cover;
} 
</style>
</head>
<body>

	<div id="container">
		<h2>欢迎登录</h2>
		<form action="admincheck" method="post">
			管理员名：<input type="text" name="adminname"><br>
			密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码： <input type="password" name="adminpasswd"><br>
			<input type="submit" value="登录">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重填"> <br>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="index">返回首页</a>
		</form>
		<%
		if(error!=null){
			switch(error){
			case "1":%>
		<p>请填写管理员和密码
		<p>
			<% 
				break;
			case "2":
				%>
		
		<p>管理员或密码错误
		<p>
			<% 
				break;
			}
		}
	%>
		
	</div>


</body>
</html>