<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>店铺历史销售查询</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/admin/sales/query.css" rel="stylesheet">
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
<div id="result">
    <div>
        <form action="${pageContext.request.contextPath}/sale/query" method="post" onsubmit="return test()">
            <table>
                <tr>
                    <td><label for="storeId">店铺ID：</label></td>
                    <td colspan="3"><input type="text" name="storeId" id="storeId" value="${qstoreId}"
                                           placeholder="请输入店铺ID"
                                           class="form-control"></td>
                </tr>
                <tr>
                    <td><label for="name">店铺名：</label></td>
                    <td colspan="3"><input type="text" name="name" id="name" value="${qname}" placeholder="请输入店铺名"
                                           class="form-control"></td>
                </tr>
                <tr>
                    <td><label for="minmoney">销售额范围：</label></td>
                    <td><input type="text" name="minmoney" id="minmoney" value="${minmoney}" class="form-control"></td>
                    <td><label for="maxmoney">至</label></td>
                    <td><input type="text" name="maxmoney" id="maxmoney" value="${maxmoney}" class="form-control"></td>
                </tr>
            </table>
            <input class="btn" type="submit" value="查询"/>
            <input class="btn" type="reset" value="重置"/><br>
        </form>

        <c:forEach items="${list1}" var="querystore">
            <c:if test="${querystore.membership==Admin.administratorId}">
                <table id="store" class="table">
                    <tr class="success">
                        <td>店铺ID：</td>
                        <td>${querystore.storeId}</td>
                        <td>店铺名字：</td>
                        <td>${querystore.name}</td>


                        <td>联系电话：</td>
                        <td>${querystore.phone}</td>
                        <td>店铺地址：</td>
                        <td>${querystore.address}</td>

                        <td>
                            <a href="${pageContext.request.contextPath}/sale/jumpdateview?storeId=${querystore.storeId}">查看柱状图</a>
                        </td>

                    </tr>
                </table>

                <br><br>
                <c:forEach items="${list}" var="sales">
                    <c:if test="${sales.storeId==querystore.storeId}">
                        <table ID="saleslist" class="table table-striped table-hover">
                            <tr>
                                <td>销售记录ID</td>
                                <td>时间</td>
                                <td>收入</td>
                                <td>订单数</td>
                                <td>备注</td>
                            </tr>
                            <tr>
                                <td>${sales.saleId}</td>
                                <td>${sales.sTime}</td>
                                <td>${sales.income}</td>
                                <td>${sales.orders}</td>
                                <td>${sales.remarks}</td>
                            </tr>
                        </table>
                    </c:if>
                </c:forEach>
            </c:if>
        </c:forEach>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/admin/sales/query.js"></script>
</html>
