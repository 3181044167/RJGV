<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.taihu.model.*,com.taihu.dao.*,java.util.*"%>

<%
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("productList");
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
a {
	display: block;
	float: left;
	width: 80px;
	height: 30px;
	text-align: center;
	line-height: 29px;
	font-weight: bold;
}

a:link, a:visited {
	color: white;
	text-decoration: none;
	background: url(image/menubg.gif) no-repeat 0px -29px;
}

a:hover {
	color: white;
	text-decoration: none;
	background: url(image/menubg.gif) no-repeat 0px 0px;
}

a:active {
	color: red;
}

#container {
	width: 800px;
	height: 800px;
	margin: 0 auto;
}

#top {
	width: 800px;
	height: 20px;
}

#titles {
	width: 800px;
	height: 20px;
}

#main {
	width: 800px;
	height: 760px;
}
</style>
</head>
<body >
	<div id="container">
		<div id="top">
			<table align="right">
				<tr>
					<td><a href="login.jsp">登陆</a></td>
					<td><a href="register.jsp">注册</a></td>
					<td><a href="adminL.jsp">管理员</a></td>
				</tr>
			</table>

		</div>
		<div id="title">
			<h1 color="#336666">欢迎登录网上书城商城</h1>
		</div>

		<div id="main">
			<table border="1">
				<tr>
					
					<td>商品名称</td>
					<td>图片</td>
					<td>价格</td>
					<td>描述</td>
				<tr>
		<%
		for(Product p:list){
			
		%>
				
				<tr>
					
					<td><%=p.getPname() %></td>
					<td><img src="image/<%=p.getImgName() %>" width="300"
						height="150" alt="<%=p.getPname() %>" title="<%=p.getPname() %>"></td>
					<td><%=p.getPrice() %></td>
					<td><%=p.getDetail() %></td>
				<tr>
					<% 
		}
			
		%>
				
			</table>
		</div>
	</div>



</body>
</html>