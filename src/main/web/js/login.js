$("#submit").click(function () {
    var username = $("#username").val();
    var password = $("#password").val();
    $("#danger").text("请稍后...");
    $.post("/hotel/api/login",
        {
            "name": username,
            "password": password
        },
        function (data, status) {
            //data={result:true/false}
            if (data["result"]){
                $("#danger").text("登录成功");
                // url
                window.location.href = "room";
            }else {
                $("#danger").text("密码错误或用户名错误");
            }

        });
});
