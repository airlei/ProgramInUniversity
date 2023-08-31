<%--
  Created by IntelliJ IDEA.
  User: 23168
  Date: 2022/5/20
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书信息</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<form action="addsave.jsp" method="post">
    <h2>添加图书信息</h2>
    <table style="width: 50%">
        <tr>
            <th width="30%">书名：</th>
            <td width="70%"><input name="bookname" type="text"></td>
        </tr>
        <tr>
            <th>作者：</th>
            <td><input name="author" type="text"></td>
        </tr>
        <tr>
            <th>价格：</th>
            <td><input name="price" type="text">元</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="submit" value="添加"> <input type="reset" value="重置"></td>
        </tr>
    </table>
</form>

</body>
</html>