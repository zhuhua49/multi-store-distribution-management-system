<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>修改信息</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/member/changeInformation.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/member/msg.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/member/logincenter">多店铺分销管理系统——会员端</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${pageContext.request.contextPath}/message/membermsg"><span class="glyphicon glyphicon-envelope"></span> 消息<div class="nav-counter" id="nav-counter">${sessionScope.Msgnumber}</div></a></li>
            <li><a href="${pageContext.request.contextPath}/member/logincenter"><span class="glyphicon glyphicon-user"></span> ${sessionScope.Name}</a></li>
            <li><a href="${pageContext.request.contextPath}/member/loginout"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
        </ul>
    </div>
</nav>

<c:forEach items="${list}" var="member" >
<div class="col-lg-1" id="leftnav">
    <ul class="nav nav-pills nav-stacked">
        <li role="presentation"><a href="${pageContext.request.contextPath}/member/logincenter">
            <div>
                <img src="${pageContext.request.contextPath}/image/admin/corelevel.png" alt="个人中心">个人中心
            </div>
        </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/member/findci?memberId=${sessionScope.MemberId}">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/salesadd.png" alt="修改信息">修改信息
                </div>
            </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/member/findcp?memberId=${sessionScope.MemberId}">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/salesadd.png" alt="修改密码">修改密码
                </div>
            </a>
        </li>
        <li role="presentation">
            <a href="${pageContext.request.contextPath}/message/membermsg">
                <div>
                    <img src="${pageContext.request.contextPath}/image/admin/pushquery.png" alt="消息管理">消息管理
                </div>
            </a>
        </li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/member/changeInformation?memberId=${member.memberId}" method="post" onsubmit="return test()">
    <table>
        <tr>
            <td><label for="name">会员姓名：</label></td>
            <td><input type="text" name="name" id="name" value="${member.name}" class="form-control"></td>
            <td><label for="name">年龄：</label></td>
            <td><input type="text" name="age" id="age" value="${member.age}" class="form-control"></td>
            <td><label for="name">性别：</label></td>
            <td><input type="text" name="sex" id="sex" value="${member.sex}" class="form-control"></td>
        </tr>
        <tr>
            <td><label for="name">地址：</label></td>
            <td colspan="3"><input type="text" name="address" id="address" value="${member.address}" class="form-control"></td>
            <td><label for="name">电话：</label></td>
            <td><input type="text" name="phone" id="phone" value="${member.phone}" class="form-control"></td>
        </tr>
    </table>
    <input class="btn" type="submit" value="提交"/>
    <input class="btn" type="reset" value="重置"/><br>
</form>
</c:forEach>
</body>
<script src="${pageContext.request.contextPath}/js/member/changeInformation.js"></script>
<script>
    var n = ${sessionScope.Msgnumber};
    if (n==0){
        $('#nav-counter').hide();
    }else {
        $('#nav-counter').show();
    }
</script>
</html>
