<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>店铺修改</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/admin/manage/revise.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/logincenter">多店铺分销管理系统——店长端</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/admin/logincenter"><span class="glyphicon glyphicon-user"></span> ${sessionScope.Admin.adminName}
            </a></li>
            <li><a href="${pageContext.request.contextPath}/admin/loginout"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
        </ul>
    </div>
</nav>

<div class="col-lg-1" id="leftnav">
    <ul class="nav nav-pills nav-stacked">
        <li role="presentation"><a href="${pageContext.request.contextPath}/sale/jumpadd">
            <div>
                <img src="${pageContext.request.contextPath}/image/admin/salesadd.png" alt="店铺销售记录添加">店铺销售记录添加
            </div>
        </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/sale/jumpsquery">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/salesquery.png" alt="店铺历史销售查询">店铺历史销售查询
                </div>
            </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/sale/jumpcontrast">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/salescontrast.png" alt="多店铺销售对比">多店铺销售对比
                </div>
            </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/store/jumpmquery">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/managequery.png" alt="店铺管理">店铺管理
                </div>
            </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/member/jumpcorelevel">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/corelevel.png" alt="会员等级及积分管理">会员等级及积分管理
                </div>
            </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/message/jumpmessage">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/pushquery.png" alt="推送消息">推送消息
                </div>
            </a>
        </li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/store/update" method="post" onsubmit="return test()">
    <table>
        <tr>
            <td><label for="storeId">店铺ID：</label></td>
            <td><input type="text" name="storeId" id="storeId" value="${list[0].storeId}" readonly></td>
        </tr>
        <tr>
            <td><label for="name">店铺名：</label></td>
            <td><input type="text" name="name" id="name" value="${list[0].name}" placeholder="请输入店铺名"  class="form-control"></td>
            <td><label for="phone">电话：</label></td>
            <td><input type="text" name="phone" id="phone" value="${list[0].phone}" placeholder="请输入电话"  class="form-control"></td>
        </tr>
        <tr>
            <td><label for="address">地址：</label></td>
            <td colspan="3"><input type="text" name="address" id="address" value="${list[0].address}" placeholder="请输入地址"  class="form-control"></td>
        </tr>
        <tr>
            <td><label for="adminname">管理员姓名：</label></td>
            <td><input type="text" name="adminname" id="adminname" class="form-control" value="${list1[0].adminName}"></td>
            <td><label for="adminphone">手机号码：</label></td>
            <td><input type="text" name="adminphone" id="adminphone" class="form-control" value="${list1[0].phone}"></td>
        </tr>
        <tr>
            <td><label for="pwd">密码：</label></td>
            <td><input type="password" name="pwd" id="pwd" class="form-control" value="${list1[0].pwd}"></td>
            <td><label for="password0">确认密码：</label></td>
            <td><input type="password" name="password0" id="password0" class="form-control" value="${list1[0].pwd}"></td>
        </tr>
    </table>
    <input class="btn" type="submit" value="修改" />
    <input class="btn" type="reset" value="重置" /><br>
</form>

</body>
<script src="${pageContext.request.contextPath}/js/admin/manage/add.js"></script>
</html>
