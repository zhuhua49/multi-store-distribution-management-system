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

    var sex = $("#sex").val();
    var reg3 = /^([男女])$/;
    if (sex === "" || !reg3.test(sex)) {
        alert('性别：请输入 男 或 女');
        $("#sex").focus();
        return false;
    }

    var phone = $("#phone").val();
    var reg4 = /^[1]\d{10}$/;
    if (phone === "" || !reg4.test(phone)) {
        alert('手机号码：请输入正确的格式');
        $("#phone").focus();
        return false;
    }

    var address = $("#address").val();
    var reg5 = /^[\u4e00-\u9fa5]{2,}[\u4E00-\u9FA5A-Za-z0-9]*$/;
    if (address === "" || !reg5.test(address)) {
        alert('地址：请输入正确的格式');
        $("#address").focus();
        return false;
    }
}