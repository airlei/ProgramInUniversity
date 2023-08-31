<%--
  Created by IntelliJ IDEA.
  User: 23168
  Date: 2022/5/20
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" language="java" %>
<html>
<head>
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");


    String id = request.getParameter("id");
    String name = request.getParameter("name");



    String sex = request.getParameter("sex");
    String birthday = request.getParameter("birthday");

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8", "root", "2316811443");

    PreparedStatement stmt = con.prepareStatement("insert into student(id,name,sex,birthday) values(?,?, ?, ?)");


    stmt.setString(1, id);
    stmt.setString(2, name);
    stmt.setString(3, sex);
    stmt.setString(4, birthday);
    int i = stmt.executeUpdate();


    if (i == 1) {
        out.println("<h2>添加成功！</h2><br/>");
        out.println("<a href='index.jsp'>返回首页</a>");
    } else {
        out.println("<h2>添加失败！</h2><br/>");
        out.println("<a href='add.jsp'>重新添加</a>");
    }
    stmt.close();
    con.close();

%>
</body>
</html>