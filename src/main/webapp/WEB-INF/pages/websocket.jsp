<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>聊天页面</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="${pageContext.request.contextPath}/css/websocket.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${rt}">${ms}</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="${rt}"><span class="glyphicon glyphicon-user"></span>${name}
            </a></li>
            <li><a href="${close}"><span class="glyphicon glyphicon-log-out"></span> 注销</a></li>
        </ul>
    </div>
</nav>

<nav class="navbar navbar-default" role="navigation">
    <p class="navbar-text">发送给:${receiver}</p>
</nav>

<input id="sender" name="sender" type="text" style="display:none" value="${sender}">
<input id="administratorId" name="administratorId" type="text" style="display:none" value="${administratorId}">
<input id="memberId" name="memberId" type="text" style="display:none" value="${memberId}">
<input id="receiver" name="receiver" type="text" style="display:none" value="${receiver}">

<div class="talk_show">
    <c:forEach items="${list2}" var="list2">
        <c:if test="${list2.administratorId==administratorId && list2.memberId==memberId}">
            <c:if test="${sender!=list2.sender}">
            <div class="atalk"><span>${list2.messageDate}<br>${list2.sender}：${list2.messageText}</span></div>
            </c:if>
            <c:if test="${sender==list2.sender}">
            <div class="btalk"><span>${list2.messageDate}<br>${list2.sender}：${list2.messageText}</span></div>
            </c:if>
        </c:if>
    </c:forEach>
    <div id="cont"></div>
</div>

<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
    <input type="text" class="navbar-left navbar-btn form-control" id="message">
    <input type="button" id="sebd" value="发送" onclick="send()" class="btn navbar-right navbar-btn">
</nav>

</body>

<script src="https://cdn.staticfile.org/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

    var webSocket = null;
    var url = null;
    var count = 0;

    /**
     * 创建连接
     */
    window.onload = function connect() {

        urlPath = "/msdm_war/handler";

        /**
         * 判断协议 - http or https
         */
        url = isUrl(urlPath);

        /**
         * 显示信息
         */
        console.log("链接url为:" + url);

        /**
         * 建立连接
         */
        webSocket = new WebSocket(url);

        /**
         * 连接成功
         */
        webSocket.onopen = function () {
            console.log('Info: 连接成功.');
        };

        /**
         * 连接失败
         */
        webSocket.onerror = function () {
            console.log('Info: 连接失败.');
        };

        /**
         * 连接断开
         */
        webSocket.onclose = function (event) {
            alert('websocket 断开: ' + event.code + ' ' + event.reason + ' ' + event.wasClean);
            console.log('Info: 连接断开.');
            console.log(event.data);
        };

        /**
         * 来自服务器的消息
         */
        webSocket.onmessage = function (event) {
            var data = JSON.parse(event.data);
            //var message = "输出消息";
            //showText(message);
            //console.log("Id为"+data['fromId']+"   fromname为"+data['fromName']+"   toId为"+data['toId']+"   messageId为"+data['messageId']+"   messageText为"+data['messageText']);
            if (data['sender']==document.getElementById('sender').value){
                showText(data['messageDate'] + '<br/>' + data['sender'] + ':' + data['messageText']);
            }else {
                ashowText(data['messageDate'] + '<br/>' + data['sender'] + ':' + data['messageText']);
            }
        };

    }


    /**
     * 发送消息
     */
    function send() {
        // 判断是否已连接
        if (webSocket != null) {
            // 新建data对象，并规定属性名与相应的值
            var data = {};
            /**
             // 发送者ID
             data['fromId'] = 'NZ-ID-' + new Date().getTime();
             // 发送者Name
             data['fromName'] = 'NZ-FN-' + new Date().getTime();;
             // 接收者ID - userSocketSessionMap - key
             data['toId'] = document.getElementById('sender').value;
             // 发送的消息
             data['messageText'] = document.getElementById('message').value;
             */
            //发送者名字
            data['sender'] = document.getElementById('sender').value;
            //接收者名字
            data['receiver'] = document.getElementById('receiver').value;
            //管理员ID
            data['administratorId'] = document.getElementById('administratorId').value;
            //会员id
            data['memberId'] = document.getElementById('memberId').value;
            // 发送的消息
            data['messageText'] = document.getElementById('message').value;
            // 将对象封装成JSON后发送至服务器
            webSocket.send(JSON.stringify(data));
            // 显示消息
            console.log('Sent: ' + data['messageText']);

        } else {
            console.log('Send: 连接未建立，请连接。');
        }

    }

    /**
     * 显示文本
     * @param message
     */
    function showText(message) {
        //document.getElementById('cont').className='btalk';
        var console = $('#cont');
        $(console).html($(console).html() +"<div class=\"btalk\"><span id=\"console\">"+message+"</span></div>");
        $("#message").val("");

    }
    function ashowText(message) {
        //document.getElementById('cont').className='atalk';
        var console = $('#cont');
        $(console).html($(console).html() +"<div class=\"atalk\"><span id=\"console\">"+message+"</span></div>");
        $("#message").val("");

    }

    /**
     * 判断协议 - http or https
     */
    function isUrl(urlPath) {

        if (window.location.protocol == 'http:') {
            return 'ws://' + window.location.host + urlPath;
        } else {
            return 'wss://' + window.location.host + urlPath;
        }

    }

</script>

</html>