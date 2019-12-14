<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>会员注册</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/member/register.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/storeV/admin/center">多店铺分销管理系统——会员端</a>
        </div>
    </div>
</nav>

<form action="${pageContext.request.contextPath}/member/register" method="post" onsubmit="return test()">
    <table>
        <tr>
            <td><label for="name">会员姓名：</label></td>
            <td><input type="text" name="name" id="name"></td>
            <td><label for="age">年龄：</label></td>
            <td><input type="text" name="age" id="age"></td>
            <td><label for="sex">性别：</label></td>
            <td><input type="text" name="sex" id="sex"></td>
        </tr>
        <tr>
            <td><label for="phone">电话：</label></td>
            <td><input type="text" name="phone" id="phone"></td>
            <td><label for="address">地址：</label></td>
            <td colspan="3"><input type="text" name="address" id="address"></td>
        </tr>
        <tr>
            <td><label for="administratorId">所属店铺：</label></td>
            <td><input type="text" name="administratorId" id="administratorId"></td>
            <td><label for="pwd">密码：</label></td>
            <td><input type="password" name="pwd" id="pwd"></td>
            <td><label for="password0">确认密码：</label></td>
            <td><input type="password" name="password0" id="password0"></td>
        </tr>
    </table>
    <input class="btn" type="submit" value="注册" />
    <input class="btn" type="reset" value="重置" /><br>
</form>

</body>
<script src="${pageContext.request.contextPath}/js/member/register.js"></script>
</html>
