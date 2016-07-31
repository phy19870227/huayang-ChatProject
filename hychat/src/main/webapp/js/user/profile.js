/**
 * Created by buhuayang on 16/7/30.
 */
//# sourceURL=sourceUrl=profile.js
var Profile = function () {

    var bindEditHeadImgEvent = function () {
        $("#headImg").fileinput();
    }
    
    var saveProfile = function () {
        $("#profile_form").ajaxSubmit({
            dataType: "json",
            clearForm: false,
            success: function (resp, textStatus, jqXHR) {

            }
        });
    }

    return {
        init: function () {
            bindEditHeadImgEvent();
        }
    }

}();
$(function () {
    Profile.init();
});