function revise() {
    $('#revise').modal('show')
}

function test1() {
    var phone = $("#phone").val();
    var reg = /^[1]\d{10}$/;
    if (phone === "" || !reg.test(phone)) {
        alert('手机号码：请输入正确的格式');
        $("#phone").focus();
        return false;
    }
}

function test2() {
    var memberID = $("#memberID").val();
    if (memberID === "") {
        alert('请先进行查询');
        return false;
    }

    var core = $("#core").val();
    var reg = /^(0|[1-9][0-9]*)$/;
    if (core === "" || !reg.test(core)) {
        alert('店铺积分：请输入数字');
        $("#core").focus();
        return false;
    }
}