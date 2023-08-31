<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css">
	<script src="layui/layui.js"></script>
<style>
	body{
		background:url("img/1.jpg")no-repeat;
		background-size:100% 100% ; 
	background-attachment: fixed 
		
	}
	.zhuti{
		text-align:center;
		margin:100px;
		font-family:黑体;
		color:#33FFFF;
	}
	input{
		padding-left:15px;
	}
</style>
</head>
<body>
<div class="zhuti">
	<form action="Servlet?method=add" method="post">
		<h1> 添 加 学 生 信 息</h1>
		<br><br><br>
		
		<div style="text-align:center; "><h3>名字</h3> </div><br>
		<input type="text" name="name" class="layui-input" placeholder="请输入姓名" required="required">
		<br><br>
		<div style="text-align:center; "><h3>性别</h3> </div><br>
		<input type="text" name="sex" class="layui-input" placeholder="请输入性别" required="required">
		<br><br>
		<div style="text-align:center; "><h3>生日&nbsp;</h3> </div><br>
		<input type="text" name="birthday" class="layui-input" placeholder="请输入生日" required="required">
		<br><br>
		<div style="text-align:center; ">
		<input type="submit" value="提交" class="layui-btn layui-btn-warm layui-btn-radius">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置" class="layui-btn layui-btn-warm layui-btn-radius">
		</div>
	</form>
</div>
</body>
</html>