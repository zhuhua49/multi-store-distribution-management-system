<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>店铺历史销售柱状图</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/admin/sales/dateview.css" rel="stylesheet">
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

<form action="${pageContext.request.contextPath}/sale/dateview?storeId=${list[0].storeId}" method="post" onsubmit="return test()">
    <table>
        <tr>
            <td>店铺ID：</td>
            <td>${list[0].storeId}</td>
            <td>店铺名字：</td>
            <td>${list[0].name}</td>
        </tr>
        <tr>
        <td>联系电话：</td>
        <td>${list[0].phone}</td>
        <td>店铺地址：</td>
        <td>${list[0].address}</td>
        <tr>
            <td><label for="StartDate">起止时间：</label></td>
            <td><input type="date" name="StartDate" id="StartDate" value="${StartDate}" class="form-control"></td>
            <td><label for="EndDate">至</label></td>
            <td><input type="date" name="EndDate" id="EndDate" value="${EndDate}" class="form-control"></td>
        </tr>
    </table>
    <input class="btn" type="submit" value="查看">
</form>
<br>
<canvas id="a_canvas" width="800" height="375"></canvas>

</body>
<script src="${pageContext.request.contextPath}/js/admin/sales/dateview.js"></script>
<script>
    (function () {

        window.addEventListener("load", function () {
            //var date = new ArrayList();
            var data = "${listMoney}".replace('[', '').replace(']', '').split(',');
            // var xinforma = new ArrayList();
            var xinforma = "${listDate}".replace('[', '').replace(']', '').split(',');

            // var data = [1000,1300,2000,3000,2000,2000,1000,1500,2000,5000,1000,1000,1000,1300,2000,		 3000,2000,2000,1000,1500,2000,5000,1000,1000,2000,1000,1500,2000,5000,1000,		1000];
            // var xinforma = ['1','2','3','4','5','6','7','8','9','10','11','12','13','14','15'
            //     ,'16','17','18','19','20','21','22','23','24','25','26','27','28'
            //    ,'29','30','31'];

            // 获取上下文
            var a_canvas = document.getElementById('a_canvas');
            var context = a_canvas.getContext("2d");


            // 绘制背景
            var gradient = context.createLinearGradient(0, 0, 0, 300);


            // gradient.addColorStop(0,"#e0e0e0");
            //gradient.addColorStop(1,"#ffffff");


            context.fillStyle = gradient;

            context.fillRect(0, 0, a_canvas.width, a_canvas.height);

            var realheight = a_canvas.height - 15;
            var realwidth = a_canvas.width - 40;
            // 描绘边框
            var grid_cols = data.length + 1;
            var grid_rows = 4;
            var cell_height = realheight / grid_rows;
            var cell_width = realwidth / grid_cols;
            context.lineWidth = 1;
            context.strokeStyle = "#a0a0a0";

            // 结束边框描绘
            context.beginPath();
            // 准备画横线
            /*for(var row = 1; row <= grid_rows; row++){
              var y = row * cell_height;
              context.moveTo(0,y);
              context.lineTo(a_canvas.width, y);
            }*/

            //划横线
            context.moveTo(0, realheight);
            context.lineTo(realwidth, realheight);


            //画竖线
            context.moveTo(0, 20);
            context.lineTo(0, realheight);
            context.lineWidth = 1;
            context.strokeStyle = "black";
            context.stroke();


            var max_v = 0;

            for (var i = 0; i < data.length; i++) {
                if (data[i] > max_v) {
                    max_v = data[i]
                }
                ;
            }
            max_v = max_v * 1.1;
            // 将数据换算为坐标
            var points = [];
            for (var i = 0; i < data.length; i++) {
                var v = data[i];
                var px = cell_width * (i + 1);
                var py = realheight - realheight * (v / max_v);
                //alert(py);
                points.push({"x": px, "y": py});
            }

            //绘制坐标图形
            for (var i in points) {
                var p = points[i];
                context.beginPath();
                context.fillStyle = "green";
                context.fillRect(p.x, p.y, 15, realheight - p.y);

                context.fill();
            }
            //添加文字
            for (var i in points) {
                var p = points[i];
                context.beginPath();
                context.fillStyle = "black";
                context.fillText(data[i], p.x + 1, p.y - 15);
                context.fillText(xinforma[i], p.x + 1, realheight + 12);
                context.fillText('日期/号', realwidth, realheight + 12);
                context.fillText('收入/元', 0, 10);
            }
        }, false);
    })();

</script>
</html>
