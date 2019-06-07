<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.taihu.dao.*,com.taihu.model.*"%>
<%
    	String spid = request.getParameter("pid");
    int pid=0;
    	if (spid != null){
    		 pid = Integer.parseInt(spid);
    	}
    //到数据库中取出该商品的全部信息
    	ProductDao productDao = new ProductDao();
    	Product product = productDao.getById(pid);
    
    
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
	<h1>修改商品信息</h1>
	<form action="updateProduct" method="post">
		商品ID： <input type="text" name="pid" value="<%=product.getPid()%>"
			readonly="readonly"><br> 商品名称：<input type="text"
			name="pname" value="<%=product.getPname()%>"><br> 商品价钱：<input
			type="text" name="price" value="<%=product.getPrice()%>"><br>
		商品描述：<input type="text" name="detail" value="<%=product.getDetail()%>"><br>
		<input type="submit" value="修改"> <input type="reset"
			value="取消">


	</form>

</body>
</html>