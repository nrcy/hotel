//一下函数为判断str中是否带有中文，true为不存在
function isNotChinese(str){
    var patrn=/[\u4E00-\u9FA5]|[\uFE30-\uFFA0]/gi;
    if(!patrn.exec(str)){
        return true;
    }else{
        return false;
    }
}

// 判断姓名是否重复
$("#username").blur(function () {
    if (!isNotChinese($("#username").val())){
        $("#danger").text("姓名中不能带有中文");
        return;
    }else {
        $("#danger").text("欢迎注册");
    }
    $.post("/hotel/api/verificationName",
        {
            name:$("#username").val()
        },
        function(data){
            //json={result:true/false}
            var json = JSON.parse(data);
            var result = json["result"];
            if(eval(result)){
                $("#danger").text("欢迎注册");
            }else{
                $("#danger").text("姓名重复，请更改姓名！");
            }

        });
});

//判断密码为数字
$("#password1").blur(function () {
    if (!isNaN(Number($("#password1").val()))){
        $("#danger").text("欢迎注册");
    }else {
        $("#danger").text("密码必须为数字");
    }
});

//    判断两次密码是否一致
$("#password2").blur(function () {
    if ($("#password2").val() != $("#password1").val()) {
        $("#danger").text("密码不一致");
    }else {
        $("#danger").text("欢迎注册");
    }
});
//    注册
$("#submit").click(function () {
    if ($("#danger").text() == "欢迎注册" &&
        $("#username").val() != "" &&
        $("#password2").val() != "" &&
        isNotChinese($("#username").val()) &&
        $("#password2").val() == $("#password1").val() &&
        !isNaN(Number($("#password1").val()))) {
        $.post("/hotel/api/register",
            {
                name:$("#username").val(),
                password:$("#password2").val()
            },
            function(data,status){
                //json={result:true/false}
                var json = JSON.parse(data);
                var result = json["result"];
                if (eval(result)) {
                    $("#modal").modal("show");
                } else {
                    $("#danger").text("注册失败，请联系客服！");
                }
            });
    }else {
        alert("请正确填写信息！");
    }
});
//    对话框的跳转
$("#login").click(function () {
    $("#modal").modal("hide");
    window.location.href = "login";
});