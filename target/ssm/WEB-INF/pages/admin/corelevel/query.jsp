<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>会员等级及积分管理</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/admin/corelevel/query.css" rel="stylesheet">
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

<form action="${pageContext.request.contextPath}/member/findphone" onsubmit="return test1()" method="post">
    <label for="phone">会员电话：</label>
    <input type="text" name="phone" id="phone" class="form-control" value="${phone}"
           placeholder="请输入会员电话"><br>

    <input class="btn" type="submit" value="查询"/>
    <input class="btn" type="reset" value="重置"/>
    <input class="btn" type="button" value="修改会员等级或积分" onclick="revise()"/><br>
</form>
<div id="result">
    <div>
        <form action="${pageContext.request.contextPath}/member/membermage" onsubmit="return test2()" method="post">
            <table class="table table-bordered">
                <tr>
                    <td>会员姓名：</td>
                    <td>${list[0].name}</td>
                    <td>年龄：</td>
                    <td>${list[0].age}</td>
                    <td>性别：</td>
                    <td>${list[0].sex}</td>
                </tr>
                <tr>
                    <td>地址：</td>
                    <td colspan="3">${list[0].address}</td>
                    <td>电话：</td>
                    <td>${list[0].phone}</td>
                </tr>
                <tr>
                    <td>店铺名字：</td>
                    <td>${list1[0].name}</td>
                    <td>店铺积分：</td>
                    <td>${list[0].core}</td>
                    <td>会员等级：</td>
                    <td>${list[0].level}</td>
                </tr>
            </table>

            <input type="hidden" name="memberId" id="memberId" value="${list[0].memberId}">

            <div class="modal fade" id="revise" tabindex="-1" role="dialog" aria-labelledby="Label" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="Label">修改会员等级或积分</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="core" class="col-sm-2 control-label">店铺积分</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="core" id="core" class="form-control"
                                               value="${list[0].core}"
                                               v-model="blogtext">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="level" class="col-sm-2 control-label">会员等级</label>
                                    <div class="col-sm-10">
                                        <select class="form-control" name="level" id="level"
                                                v-model="blogtext">
                                            <option value="${list[0].level}">不修改</option>
                                            <option>普通会员</option>
                                            <option>高级会员</option>
                                            <option>超级会员</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-default" type="button" data-dismiss="modal">关闭</button>
                            <input class="btn btn-default" type="submit" value="发送"/>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal -->
            </div>
        </form>
    </div>
</div>

</body>
<script src="${pageContext.request.contextPath}/js/admin/corelevel/query.js"></script>
</html>
