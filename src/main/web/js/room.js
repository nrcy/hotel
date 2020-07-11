
//是否订早餐
var breakfast = false;
//订阅房间页面的打开
var hasHistory = false;

function hasHistoryFunc(){
    $.get("/hotel/api/have_history", function (data) {
        var json = JSON.parse(data);
        hasHistory = eval(json["result"]);
        if (hasHistory){
            $(".historyIndex").text("1");
            $("#check_out").css("display", "block");
        } else {
            $(".historyIndex").text("0");
            $("#check_out").css("display", "none");
        }
    });
}

$(function () {
    hasHistoryFunc();
});

$(".choose").click(function (event) {

    if (hasHistory) {
        //有
        $("#has_history_tips").modal("show");
    } else {
        var type = "";
        $("#room_information").modal("show");
        if ($(event.target).attr("value") == "one") {
            type = "1";
        } else {
            type = "2";
        }
        $.post("/hotel/api/get_room",
            {
                "type": type
            },
            function (data) {
                //data = {"floor":2,"id":31,"num":1,"price":246,"size":15,"status":0,"type":1}
                var json = JSON.parse(data);
                var roomId = json["floor"] * 100 + json["num"];
                $("#roomId").text(roomId);
                $("#roomSize").text(json["size"]);
                $("#price").text(json["price"]);
            });
    }
});


//计算价钱
$(".breakfast").click(function (event) {
    if ($(event.target).attr("value") == "true" && !breakfast) {
        breakfast = true;
        var price = Number($("#price").text())
        $("#price").text((price + 10).toString())
    } else if ($(event.target).attr("value") == "false" && breakfast) {
        breakfast = false;
        var price = Number($("#price").text())
        $("#price").text((price - 10).toString())
    }
});

// 订房
$("#submit").click(function () {
    $.post("/hotel/api/reserve",
        {
            "roomId": $("#roomId").text(),
            "breakfast": breakfast.toString()
        }, function (data) {
            var json = JSON.parse(data);
            if (eval(json["result"])) {
                alert("预定成功");
                hasHistoryFunc();
            } else {
                alert("预定失败, 请联系客服");
            }
        });
});

// 退房页面的打开
$("#check_out").click(function () {
    $("#history").modal("show");
    $.get("/hotel/api/history", function (data) {
        var json = JSON.parse(data);
        $("#roomIdPay").text(json["roomId"]);
        $("#pricePay").text(json["price"]);
    });
});

// 退房支付按钮的打开
$("#check").click(function () {
    if ($("#check").prop("checked")) {
        $("#pay_submit").removeAttr("disabled");
    } else {
        $("#pay_submit").attr("disabled", "disabled");
    }
});

//支付
$("#pay_submit").click(function () {
    $.get("/hotel/api/pay", function (data) {
        var json = JSON.parse(data);
        if (eval(json["result"])) {
            alert("支付成功！");
            hasHistoryFunc();
        } else {
            alert("支付失败,请联系客服解决");
        }
    });
});

// 个人信息页面的打开
$("#myself_information").click(function () {
    $("#myself_information_div").modal("show");
    $.get("/hotel/api/information", function (data) {
        var json = JSON.parse(data);
        $("#set_information_username").val(json["name"]);
        $("#set_information_password").val(json["password"]);
        $("#set_information_price").val(json["consumption"]);
    })
});

// 修改个人信息按钮的打开
$("#set_myself_information_btn").click(function () {
    $("#set_myself_information_submit").css("display", "block");
    $("#set_information_password").removeAttr("disabled");
});

//提交个人信息
$("#set_myself_information_submit").click(function () {
    $.post("/hotel/api/set_user_password",
        {
            "name": $("#set_information_username").val(),
            "password": $("#set_information_password").val()
        }, function (data) {
            var json = JSON.parse(data);
            if (eval(json["result"])) {
                alert("修改成功");
            } else {
                alert("修改失败，请联系客服！")
            }
        });
});