/**
 * Created by buhuayang on 16/7/20.
 */
$(function () {
    $("#page_index").addClass("active");
    $("#btn_register").on("click", function () {
        window.location.href = HyChat.getCtxPath() + "/register.htm";
    });
})