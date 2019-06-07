<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<form action="addUser" method="post">
		<table width="450" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<th scope="col">用户注册</th>
			</tr>
			<tr>
				<td>
					<fieldset>
						<legend>必填信息</legend>
						<table width="85%" border="0" align="center" cellpadding="0"
							cellspacing="2">
							<tr>
								<td width="25%" align="right">用户名</td>
								<td><input type="text" size="16" name="username" /></td>
							</tr>
							<tr>
								<td width="25%" align="right">密&nbsp;&nbsp;&nbsp;码</td>
								<td><input type="password" size="16" name="password" /></td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>
			<tr>
				<td>
					<fieldset>
						<legend>选填信息</legend>
						<table width="85%" border="0" align="center" cellpadding="0"
							cellspacing="2">
							<tr>
								<td width="25%" align="right">性别</td>
								<td><input type="text" size="5" name="gender" /></td>
							</tr>
							<tr>
								<td width="25%" align="right">年龄</td>
								<td><input type="text" size="5" name="age" /></td>
							</tr>
						</table>
					</fieldset>
				</td>
			</tr>

			<tr>
				<td><table width="85%" border="0" cellspacing="2"
						cellpadding="0">
						<tr>
							<td align="right"><input type="submit" value="提交" /></td>
							<td><input type="reset" value="重填" /></td>


							<td><a href="index">返回首页</a></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</form>

</body>
</html>