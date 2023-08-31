<%--
  Created by IntelliJ IDEA.
  User: 23168
  Date: 2022/9/6
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Object message = request.getAttribute("message");
    if(message!=null && !"".equals(message)){

%>
<script type="text/javascript">
    alert("<%=request.getAttribute("message")%>");
</script>
<%} %>



<form action="Servlet?method=addHetong" method="post" id="login" name="login" onsubmit="return check()">

    <table align="center" valign="middle">

        <tr>
            <td>合同名称:</td>
            <td><input type="text" name="nameHetong"  id="nameHetong" > </td></tr>


        <tr>
            <td> 货物名称：</td>
            <td><input type="text"  name="nameHuowu"> </td></tr>

        <tr>
            <td>请选择货物种类:</td>
            <td >
                <select name="selectHuowu">

                    <option value="全色染布">全色染布</option>
                    <option value="印花染布">印花染布</option>
                </select>

            </td></tr>

        <td> color：</td>
            <td><input type="text"  name="color"> </td></tr>


        <tr>
            <td> 数量：</td>
            <td><input type="text"  name="num"> </td></tr>
        <tr>
            <td> 签订日期：</td>
            <td><input type="text"  name="timeQian"> </td></tr>
        <tr>
            <td> 交货日期：</td>
            <td><input type="text"  name="timeJiao"> </td></tr>

        <tr>
            <td> 操作人：</td>
            <td><input type="text"  name="people"> </td></tr>




        <tr>  <td  colspan="2" align="center"><input type="submit" value="确定" name="submit" id="submit">
            <input type="reset" > </td>
        </tr>
    </table>
</form>
</body>
</html>
