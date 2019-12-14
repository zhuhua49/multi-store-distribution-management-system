function test() {
    var MinMoney = $("#MinMoney").val();
    var reg3 = /^[0-9]*$/;
    if (MinMoney !== "" && !reg3.test(MinMoney)) {
        alert('销售额范围：请输入正确的最小销售额');
        $("#MinMoney").focus();
        return false;
    }

    var MaxMoney = $("#MaxMoney").val();
    var reg4 = /^[0-9]*$/;
    if (MaxMoney !== "" && !reg4.test(MaxMoney)) {
        alert('销售额范围：请输入正确的最大销售额');
        $("#MaxMoney").focus();
        return false;
    }
}