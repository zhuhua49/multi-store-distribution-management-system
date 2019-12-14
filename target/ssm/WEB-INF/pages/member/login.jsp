<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>会员登录</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/member/login.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">多店铺分销管理系统——会员端</a>
        </div>
    </div>
</nav>
<form action="#" method="post" id="form">
    <table>
        <tr>
            <td><label for="phone">手机号码：</label></td>
            <td><input type="text" name="phone" id="phone" placeholder="请输入用户名" class="form-control"></td>
        </tr>
        <tr>
            <td><label for="pwd">密码：</label></td>
            <td><input type="password" name="pwd" id="pwd" placeholder="请输入密码" class="form-control"></td>
        </tr>
        <tr>
            <td><label for="code">验证码：</label></td>
            <td><input type="text" id="code" class="form-control" placeholder="请输入4位验证码"/>
                <canvas id="changeImg" width="120" height="45" title="看不清，换一张"></canvas></td>
        </tr>
    </table>
    <input class="btn" type="button" value="登录" onclick="login()"/>
    <input class="btn" type="reset" value="重置"/><br>
    不是会员，<a href="${pageContext.request.contextPath}/member/changeregister">立即注册</a>
</form>
</body>
<script src="${pageContext.request.contextPath}/js/member/login.js"></script>
<script>
    function login() {
        var code = $("#code").val();
        if (code.toUpperCase() !== contxt) {
            alert('验证码输入错误');
            $("#code").focus();
            return false;
        }else {
            $.ajax({
                url:"${pageContext.request.contextPath}/member/login",
                data:$("#form").serialize(),
                type:'post',
                success:function (data) {
                    if (data=="error"){
                        alert("用户名或密码错误！！");
                    }else{
                        alert("登录成功！！");
                        webSocket = new WebSocket('ws://' + window.location.host + '/msdm_war/handler');
                        window.location.href = "/msdm_war/member/logincenter";
                    }
                }
            })
        }
    }
</script>
<script src="${pageContext.request.contextPath}/js/member/login.js"></script>
</html>
