<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>店铺管理</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/admin/manage/query.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/logincenter">多店铺分销管理系统——店长端</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/admin/logincenter"><span
                    class="glyphicon glyphicon-user"></span> ${sessionScope.Admin.adminName}
            </a></li>
            <li><a href="${pageContext.request.contextPath}/admin/loginout"><span
                    class="glyphicon glyphicon-log-out"></span> 注销</a></li>
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

<form action="${pageContext.request.contextPath}/store/querystore" method="post" onsubmit="return test()">
    <label for="name">店铺名：</label>
    <input type="text" name="name" id="name" value="${qname}" placeholder="请输入店铺名" class="form-control"><br>
    <input class="btn" type="submit" value="查询"/>
    <input class="btn" type="reset" value="重置"/>
    <a href="${pageContext.request.contextPath}/store/jumpadd"><input class="btn" type="button" value="添加店铺"/></a><br>
</form>
<div id="result">
    <div>
        <table class="table table-striped table-hover">
            <tr>
                <td>店铺ID</td>
                <td>店铺名</td>
                <td>电话</td>
                <td>地址</td>
            </tr>
            <c:forEach items="${list1}" var="list1">
                <c:forEach items="${list}" var="store" varStatus="i">
                    <c:if test="${store.storeId==list1.storeId}">
                        <tr>
                            <td>${store.storeId}</td>
                            <td>${store.name}</td>
                            <td>${store.phone}</td>
                            <td>${store.address}</td>
                            <td><a href="${pageContext.request.contextPath}/store/jumpupdate?storeId=${store.storeId}">修改</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/store/delete?storeId=${store.storeId}">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </table>
    </div>
</div>

</body>
<script src="${pageContext.request.contextPath}/js/admin/manage/query.js"></script>
</html>
