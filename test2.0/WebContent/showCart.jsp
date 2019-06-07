<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.taihu.model.*,java.util.*"%>
<%
   
    ArrayList<CartItem> list = (ArrayList<CartItem>)session.getAttribute("CartItemList");
    double sum=0;
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
	
	width: 250px;
	height: 300px;
	margin: 0 auto;
}
</style>
</head>
<body id="container">
	<h1>购物车信息</h1>
	<table border="1">

		<tr>
			<td>商品ID</td>
			<td>商品名称</td>
			<td>价格</td>
			<td>数量</td>
		<tr>
			<%
			for(CartItem item:list){
		%>
		
		<tr>
			<td><%=item.getProduct().getPid() %></td>
			<td><%=item.getProduct().getPname() %></td>
			<td><%=item.getProduct().getPrice() %></td>
			<td><%=item.getCount() %></td>
			<%sum+=item.getProduct().getPrice()*item.getCount(); %>
		
		<tr>
			<%
		} 
		%>
		
		<tr>
			<td>总价钱</td>
			<td colspan="3"><%=sum %></td>
		<tr>
	</table>
	<a href="DeletePay">结算</a>
	<a href="manger">返回首页</a>
</body>
</html>