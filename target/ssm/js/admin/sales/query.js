function test() {
    var storeId = $("#storeId").val();
    var reg1 = /^[1-9]\d{0,2}$/;
    if (storeId !== "" && !reg1.test(storeId)) {
        alert('店铺ID：请输入正确的店铺ID');
        $("#storeId").focus();
        return false;
    }

    var name = $("#name").val();
    var reg2 = /^[\u4E00-\u9FA5A-Za-z0-9]*$/;
    if (name !== "" && !reg2.test(name)) {
        alert('店铺名：请输入正确的店铺名');
        $("#name").focus();
        return false;
    }

    var minmoney = $("#minmoney").val();
    var reg3 = /^[0-9]*$/;
    if (minmoney !== "" && !reg3.test(minmoney)) {
        alert('销售额范围：请输入正确的最小销售额');
        $("#minmoney").focus();
        return false;
    }

    var maxmoney = $("#maxmoney").val();
    var reg4 = /^[0-9]*$/;
    if (maxmoney !== "" && !reg4.test(maxmoney)) {
        alert('销售额范围：请输入正确的最大销售额');
        $("#maxmoney").focus();
        return false;
    }
}