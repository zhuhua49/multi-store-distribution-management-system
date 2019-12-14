function test() {
    var name = $("#name").val();
    var reg1 = /^[\u4e00-\u9fa5]+$/;
    if (name === "" || !reg1.test(name)) {
        alert('会员姓名：请输入汉字');
        $("#name").focus();
        return false;
    }

    var age = $("#age").val();
    var reg2 = /^[1-9][0-9]$/;
    if (age === "" || !reg2.test(age)) {
        alert('年龄：请输入正确的格式');
        $("#age").focus();
        return false;
    }

    var phone = $("#phone").val();
    var reg3 = /^[1]\d{10}$/;
    if (phone === "" || !reg3.test(phone)) {
        alert('手机号码：请输入正确的格式');
        $("#phone").focus();
        return false;
    }

    var address = $("#address").val();
    var reg4 = /^[\u4e00-\u9fa5]{2,}[\u4E00-\u9FA5A-Za-z0-9]*$/;
    if (address === "" || !reg4.test(address)) {
        alert('地址：请输入正确的格式');
        $("#address").focus();
        return false;
    }

    var storeId = $("#administratorId").val();
    var reg5 = /^[1-9]\d{0,2}$/;
    if (storeId === "" || !reg5.test(storeId)) {
        alert('所属店铺：请输入正确的店铺ID');
        $("#administratorId").focus();
        return false;
    }

    var password = $("#password").val();
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
    if (password.equals(password0)) {
        alert('两次输入的密码不一致');
        $("#password0").focus();
        return false;
    }
}