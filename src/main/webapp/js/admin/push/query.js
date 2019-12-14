function push() {
    $('#push').modal('show')
}


function setOthers() {
    var recipient = document.getElementsByName("recipient");
    for (var i = 0; i < recipient.length; i++) {
        if (recipient[i].checked == false){
            recipient[i].checked = true;
        }
        else {
            recipient[i].checked = false;
        }
    }
}

function test1() {
    var ageA = $("#ageA").val();
    var reg1 = /^[1-9][0-9]$/;
    if (ageA !== "" && !reg1.test(ageA)) {
        alert('年龄范围：请输入正确的最小年龄');
        $("#ageA").focus();
        return false;
    }

    var ageB = $("#ageB").val();
    var reg2 = /^[1-9][0-9]$/;
    if (ageB !== "" && !reg2.test(ageB)) {
        alert('年龄范围：请输入正确的最大年龄');
        $("#ageB").focus();
        return false;
    }
}

function test2() {
    var arr = [];
    $('input[name="recipient"]:checked').each(function(i){
        arr[i] = $(this).val();
    });
    if (arr.length === 0) {
        alert('请选择要推送的会员');
        return false;
    }

    var content = $("#content").val();
    var reg1 = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
    if (content === "" || !reg1.test(content)) {
        alert('内容：请输入推送内容');
        $("#content").focus();
        return false;
    }

    var remarks = $("#remarks").val();
    var reg2 = /^[\u4E00-\u9FA5A-Za-z0-9]+$/;
    if (remarks === "" || !reg2.test(remarks)) {
        alert('备注：请输入备注');
        $("#remarks").focus();
        return false;
    }
}