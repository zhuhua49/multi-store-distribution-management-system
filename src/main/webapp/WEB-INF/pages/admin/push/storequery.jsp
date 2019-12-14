<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>消息推送</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/admin/push/query.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/member/msg-blue.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/loginstorecenter">多店铺分销管理系统——分店长端</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/admin/loginstorecenter"><span
                    class="glyphicon glyphicon-user"></span> ${sessionScope.Admin.adminName}
            </a></li>
            <li><a href="${pageContext.request.contextPath}/admin/loginout"><span
                    class="glyphicon glyphicon-log-out"></span> 注销</a></li>
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

<div id="result">
    <div>
        <form action="${pageContext.request.contextPath}/message/storefindageandsex" onsubmit="return test1()"
              method="post">
            <table>
                <tr>
                    <td><label for="ageA">年龄范围：</label></td>
                    <td><input type="text" name="ageA" id="ageA" class="form-control" value="${ageA}"></td>
                    <td><label for="ageB">至</label></td>
                    <td><input type="text" name="ageB" id="ageB" class="form-control" value="${ageB}"></td>
                </tr>
                <tr>
                    <td>性别:</td>
                    <td><label class="radio-inline"><input type="radio" name="sex" value="全部" checked>全部</label></td>
                    <td><label class="radio-inline"><input type="radio" name="sex" value="男">男</label></td>
                    <td><label class="radio-inline"><input type="radio" name="sex" value="女">女</label></td>

                </tr>
            </table>
            <input class="btn" type="submit" value="查询"/>
            <input class="btn" type="reset" value="重置"/>
            <input class="btn" type="button" value="推送" onclick="push()"/><br>
        </form>

        <form action="${pageContext.request.contextPath}/message/sendmessage" onsubmit="return test2()" method="post">
            <table ID="memberlist" class="table table-striped table-hover">
                <tr>
                    <td><input class="btn" type="button" value="反选" onclick="setOthers()"/></td>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年龄</th>
                    <th>电话</th>
                    <th>地址</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${list}" var="member" varStatus="i">
                <c:if test="${member.administratorId==Admin.administratorId}">
                <label class="checkbox-inline">
                    <tr>
                        <td><label class="checkbox-inline"><input type="checkbox" name="recipient"
                                                                  value="${member.memberId}"
                                                                  checked></label></td>
                        <td>${member.name}</td>
                        <td>${member.sex}</td>
                        <td>${member.age}</td>
                        <td>${member.phone}</td>
                        <td>${member.address}</td>
                        <c:if test="${member.messagen==0}">
                            <td>
                                <a href="${pageContext.request.contextPath}/message/jumpwebsocket?memberId=${member.memberId}">发消息</a>
                            </td>
                        </c:if>
                        <c:if test="${member.messagen!=0}">
                            <td>
                                <a href="${pageContext.request.contextPath}/message/jumpwebsocket?memberId=${member.memberId}">发消息
                                    <div class="bnav-counter bnav-counter-blue">${member.messagen}</div>
                                </a></td>
                        </c:if>
                    </tr>
                    </c:if>
                    </c:forEach>
            </table>

            <div class="modal fade" id="push" tabindex="-1" role="dialog" aria-labelledby="Label" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="Label">消息推送</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-horizontal" role="form">
                                <div class="form-group">
                                    <label for="content" class="col-sm-2 control-label">内容</label>
                                    <div class="col-sm-10">
                                <textarea class="form-control" name="content" id="content"
                                          v-model="blogtext"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="remarks" class="col-sm-2 control-label">备注</label>
                                    <div class="col-sm-10">
                                <textarea class="form-control" name="remarks" id="remarks"
                                          v-model="blogtext"></textarea>
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
<script src="${pageContext.request.contextPath}/js/admin/push/query.js"></script>
<script>
    var n = ${list};
    if (n == null) {
        $('#nav-counter').hide();
    } else {
        $('#nav-counter').show();
    }
</script>
</html>