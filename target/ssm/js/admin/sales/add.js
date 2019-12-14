function test() {
    var income = $("#income").val();
    var reg = /^[0-9]*$/;
    if (income === "" || !reg.test(income)) {
        alert('收入：请输入数字');
        $("#income").focus();
        return false;
    }

    var orders = $("#orders").val();
    if (orders === "" || !reg.test(orders)) {
        alert('订单数：请输入数字');
        $("#orders").focus();
        return false;
    }
}