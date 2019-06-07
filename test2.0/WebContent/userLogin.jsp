<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.taihu.dao.*,java.util.*,com.taihu.model.*"%>
<%
    ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("productList");
    	//for(Product p:list){
    		//System.out.println(p);
    	//}
    	
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
<body id="container">
	<h1>商品信息</h1>
	<a href="index" style="text-align: right">登出</a>
	<table border="1">
		<tr>
			
			<td>商品名称</td>
			<td>图片</td>
			<td>价格</td>
			<td>描述</td>
			<td><a href="showCart.jsp">购物车</a></td>
		<tr>
			<%
		// 5处理执行的结果
		for(Product p:list){
			
		%>
		
		<tr>
			
			<td><%=p.getPname() %></td>
			<td><img src="image/<%=p.getImgName() %>" width="300"
				height="150"></td>
			<td><%=p.getPrice() %></td>
			<td><%=p.getDetail() %></td>
			<td><a href="addCart.do?pid=<%=p.getPid() %>">加入购物车</a></td>
		<tr>
			<% 
		
		}
			
		%>
		
	</table>
</body>
</html>