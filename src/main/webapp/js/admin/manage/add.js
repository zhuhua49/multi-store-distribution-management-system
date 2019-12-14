function test() {
    var name = $("#name").val();
    if (name === "" ) {
        alert('店铺名：请输入正确的店铺名');
        $("#name").focus();
        return false;
    }

    var phone = $("#phone").val();
    var reg2 = /^[1]\d{10}$/;
    if (phone === "" || !reg2.test(phone)) {
        alert('电话：请输入正确的格式');
        $("#phone").focus();
        return false;
    }

    var address = $("#address").val();
    var reg3 = /^[\u4e00-\u9fa5]{4,}[\u4E00-\u9FA5A-Za-z0-9]*$/;
    if (address === "" || !reg3.test(address)) {
        alert('地址：请输入正确的格式');
        $("#address").focus();
        return false;
    }

    var adminname = $("#adminname").val();
    var reg4 = /^[\u4E00-\u9FA5]*$/;
    if (adminname === "" || !reg4.test(adminname)) {
        alert('管理员姓名：请输入正确的管理员姓名');
        $("#adminname").focus();
        return false;
    }

    var adminphone = $("#adminphone").val();
    var reg5 = /^[1]\d{10}$/;
    if (adminphone === "" || !reg5.test(adminphone)) {
        alert('手机号码：请输入正确的格式');
        $("#adminphone").focus();
        return false;
    }

    var password = $("#pwd").val();
    var password0 = $("#password0").val();
    if (password === "") {
        alert('密码：请输入密码');
        $("#password").focus();
        return false;
    }
    if (password0 === "") {
        alert('确认密码：请再次输入密码');
        $("#password0").focus();
        return false;
    }
    if (password !== password0) {
        alert('两次输入的密码不一致');
        $("#password0").focus();
        return false;
    }
}