<%--
  Created by IntelliJ IDEA.
  User: 23168
  Date: 2022/9/6
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body{
        background:url("img/1.jpg")no-repeat;
        background-size:100% 100% ;
        background-attachment: fixed
    }
    .zhuti{
        text-align:center;
        margin:100px;
    }
</style>
<body>

<div id="serrchHetong" align="center">
    <table border="1">

<%--        <c:forEach var="u" items="${list}">--%>

            <tr>
                <td>合同名称: 2${u.nameHetong }</td>

                <td>货物名称: 2${u.nameHuowu }</td>

                <td>货物类型:  2${u.kind }</td>

                <td>货物颜色:    全色染布${u.color }</td>

                <td>货物数量:    2${u.num }</td>

                <td>签订日期:    2${u.timeQian }</td>

                <td>交货日期:    2${u.timeJiao }</td>

                <td>操作人:    2${u.people }</td>
            </tr>

<%--        </c:forEach>--%>

    </table>
</div>


</body>
</html>
