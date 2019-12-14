<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>店铺销售记录添加</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/admin/sales/add.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/loginstorecenter">多店铺分销管理系统——分店长端</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/admin/loginstorecenter"><span class="glyphicon glyphicon-user"></span> ${sessionScope.Admin.adminName}
            </a></li>
            <li><a href="${pageContext.request.contextPath}/admin/loginout"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
        </ul>
    </div>
</nav>

<div class="col-lg-1" id="leftnav">
    <ul class="nav nav-pills nav-stacked">
        <li role="presentation"><a href="${pageContext.request.contextPath}/sale/jumpstoreadd">
            <div>
                <img src="${pageContext.request.contextPath}/image/admin/salesadd.png" alt="店铺销售记录添加">店铺销售记录添加
            </div>
        </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/sale/jumpstorequery">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/salesquery.png" alt="店铺历史销售查询">店铺历史销售查询
                </div>
            </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/message/jumpstoremessage">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/pushquery.png" alt="推送消息">推送消息
                </div>
            </a>
        </li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/sale/storesaleadd" onsubmit="return test()" method="post">
    <table>
        <tr>
            <td><label for="income">收入：</label></td>
            <td><input type="text" name="income" id="income" class="form-control"></td>
            <td><label for="orders">订单数：</label></td>
            <td><input type="text" name="orders" id="orders" class="form-control"></td>
        </tr>
        <tr>
            <td><label for="remarks">备注：</label></td>
            <td colspan="3"><input type="text" name="remarks" id="remarks" class="form-control"></td>
        </tr>
    </table>
    <input class="btn" type="submit" value="添加" />
    <input class="btn" type="reset" value="重置" /><br>
</form>

</body>
<script src="${pageContext.request.contextPath}/js/admin/sales/add.js"></script>
</html>
