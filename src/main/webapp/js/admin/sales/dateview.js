function test() {
    var first = $("#StartDate").val();
    var second = $("#EndDate").val();
    var data1 = Date.parse(first.replace(/-/g,   "/"));
    var data2 = Date.parse(second.replace(/-/g,   "/"));
    var datadiff = data2-data1;
    var time = 31*24*60*60*1000;

    if (first === "") {
        alert('请输入开始时间');
        $("#StartDate").focus();
        return false;
    }

    if (second === "") {
        alert('请输入结束时间');
        $("#EndDate").focus();
        return false;
    }

    if(first.length>0 && second.length>0) {
        if (datadiff < 0 || datadiff > time) {
            alert("开始时间应小于结束时间并且间隔小于31天");
            return false;
        }
    }
}