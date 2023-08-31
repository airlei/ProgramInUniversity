<%--
  Created by IntelliJ IDEA.
  User: 23168
  Date: 2022/9/6
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销售员</title>
</head>
<body>

<table align="center" border="0px" cellpadding="10px" cellspacing="10px">

    <form action="addHetong.jsp" method = "get" >
        <tr align="center">
            <td colspan="1">
                <input type="submit" value="合同拟制" />
            </td>
        </tr>
    </form>

    <form action="serrchHetong.jsp" method = "get" >
        <tr align="center">
            <td colspan="1">
                <input type="submit" value="浏览合同" />
            </td>
        </tr>
    </form>

    <form action="serrchHetong.jsp" method = "get" >
        <tr align="center">
            <td colspan="1">
                <input type="submit" value="查询合同执行情况" />
            </td>
        </tr>
    </form>



</table>
</body>
</html>
