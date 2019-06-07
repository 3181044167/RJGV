<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
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
	<h1>添加商品</h1>
	<form action="addProduct" method="post"  enctype="multipart/form-data">
		商品名称:<input type="text" name="pname"><br> 商品价格：<input
			type="text" name="price"><br> 商品图片：<input type="file"
			name="fileImage"><br> 商品描述：
		<textarea rows="10" cols="10" name="detail"></textarea>
		<br> <input type="submit" value="添加"><input type="reset"
			value="取消">
	</form>
</body>
</html>