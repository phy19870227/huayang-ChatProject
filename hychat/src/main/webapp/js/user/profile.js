/**
 * Created by buhuayang on 16/7/30.
 */
//# sourceURL=sourceUrl=profile.js
var Profile = function () {
    
    var refreshProfile = function (chatUser) {
        HyChat.refreshContent();
        HyChat.refreshHeader(chatUser);
        HyChat.refreshSidebar(chatUser);
    };

    var bindEditHeadImgEvent = function () {
        $("#head_img_save_btn").on("click", function () {
            $("#head_img_form").ajaxSubmit({
                dataType: "json",
                clearForm: false,
                success: function (resp, textStatus, jqXHR) {
                    if (resp && resp.resultFlag == "Y") {
                        toastr.success("更新头像成功", "个人资料");
                        refreshProfile(resp.chatUser);
                    }
                },
                complete: function (XMLHttpRequest, textStatus) {
                    $("#headImg").fileinput('clear');
                }
            });
        });
        $("#profile_save_btn").on("click", function () {
            $("#profile_form").ajaxSubmit({
                dataType: "json",
                clearForm: false,
                success: function (resp, textStatus, jqXHR) {
                    if (resp && resp.resultFlag == "Y") {
                        toastr.success("更新个人资料成功", "个人资料");
                        refreshProfile(resp.chatUser);
                    }
                }
            });
        });
    }

    return {
        init: function () {
            $("#headImg").fileinput({
                language: 'zh',
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