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
    text-align: center;
} 
#container {
	width: 800px;
	height: 800px;
	margin: 0 auto;
}

</style>
</head>
<body id="container" >
	<h1>商品信息</h1>
	<a href="addProduct.jsp">添加商品</a>
	<table border="1">
		<tr>
			
			<td>商品名称</td>
			<td>图片</td>
			<td>价格</td>
			<td>描述</td>
			<td>操作</td>
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
			<td><a href="delete.do?pid=<%=p.getPid() %>" style="color: black;">删除</a> | <a
				   href="update.jsp?pid=<%=p.getPid() %>"style="color: black;">修改</a></td>
		<tr>
			<% 
		
		}
			
		%>
			<a href="adminIndex.jsp">返回管理员首页</a>
	</table>
</body>
</html>