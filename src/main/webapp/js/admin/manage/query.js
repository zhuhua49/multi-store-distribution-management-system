function test() {
    var name = $("#name").val();
    var reg = /^[\u4E00-\u9FA5A-Za-z0-9]*$/;
    if (name !== "" && !reg.test(name)) {
        alert('店铺名：请输入正确的店铺名');
        $("#name").focus();
        return false;
    }
}