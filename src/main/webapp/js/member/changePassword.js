function test() {
    var password = $("#password").val();
    var password0 = $("#password0").val();
    if (password === "") {
        alert('旧密码：请输入旧密码');
        $("#password").focus();
        return false;
    }
    if (password0 === "") {
        alert('新密码：请输入新密码');
        $("#password0").focus();
        return false;
    }
}