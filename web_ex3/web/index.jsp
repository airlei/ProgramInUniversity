<%--
  Created by IntelliJ IDEA.
  User: 23168
  Date: 2022/5/20
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>学生管理系统</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<h1>学生管理系统</h1>
<a href="WEB-INF/jsp/add.jsp">添加学生信息</a>
<br >
<br >
<table style="width: 50%;">
  <tr>

    <th>学号</th>
    <th>姓名</th>
    <th>性别</th>
    <th>生日</th>

  </tr>
  <%
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8", "root", "2316811443");
    //使用Statement对象
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select * from student");


    while (rs.next()) {
      String id = rs.getString(1);
      System.out.println("<tr><td>"+rs.getString(1) +"</td><td>"+ rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>"
              + rs.getString(4) + "</td><td><a href='edit.jsp?id=" + id
              + "'>修改</a>&nbsp;<a href='del.jsp?id=" + id + "'>删除</a></td></tr>");
    }
    rs.close();
    stmt.close();
    con.close();
  %>

</table>
</body>
</html>