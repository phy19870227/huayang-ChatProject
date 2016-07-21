/**
 * Created by buhuayang on 16/7/21.
 */
var Register = function () {
    var bindEvent = function () {
        $("#check_code_img").click(function () {
            $(this).attr("src", HyChat.getCtxPath() + "/check.jpg?_" + new Date().getTime());
        });
        $("#user_code").blur(function () {
            var userCode = $(this).val();
            var formGroup = $(this).closest(".form-group");
            var ariaDescribedby = $(this).attr("aria-describedby");
            var helpBlock = $("#" + ariaDescribedby);
            if (userCode && userCode.length >= 0) {
                $.ajax({
                    type: "get",
                    url: HyChat.getCtxPath() + "/checkUserCode.htm?userCode=" + userCode + "&_=" + new Date().getTime(),
                    cache: false,
                    dataType: "json",
                    success: function (resp) {
                        if (resp.resultFlag == "N") {
                            if (!$(formGroup).hasClass("has-error")) {
                                $(formGroup).addClass("has-error");
                            }
                        } else {
                            if ($(formGroup).hasClass("has-error")) {
                                $(formGroup).removeClass("has-error");
                            }
                        }
                    }
                });
            } else {
                if (!$(formGroup).hasClass("has-error")) {
                    $(formGroup).addClass("has-error");
                }
                $(this).tooltip({
                    trigger: "manual",
                    placement: "top",
                    title: "用户名必填!"
                }).tooltip("show");
            }
        });
    }
    return {
        init: function () {
            bindEvent();
        }
    }
}();
$(function () {
    Register.init();
});