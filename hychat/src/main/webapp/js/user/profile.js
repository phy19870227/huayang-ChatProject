/**
 * Created by buhuayang on 16/7/30.
 */
//# sourceURL=sourceUrl=profile.js
var Profile = function () {

    var bindEditHeadImgEvent = function () {
        $("#head_img_save_btn").on("click", function () {
            $("#head_img_form").ajaxSubmit({
                dataType: "json",
                clearForm: false,
                success: function (resp, textStatus, jqXHR) {
                    if (resp && resp.resultFlag == "Y") {
                        toastr.success("更新头像成功", "个人资料");
                        HyChat.refreshContent();
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#headImg").fileinput('clear');
                }
            });
        });
    }

    return {
        init: function () {
            $("#headImg").fileinput({
                showCaption: false,
                showRemove: true,
                showUpload: false
            });
            bindEditHeadImgEvent();
        }
    }

}();
$(function () {
    Profile.init();
});