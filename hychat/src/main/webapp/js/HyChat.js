/**
 * Created by buhuayang on 16/7/28.
 */
var HyChat = function () {

    var $contentWrapper = $("div.content-wrapper");
    var $contentHeader = $("section.content-header");
    var $content = $("section.content");

    var getScriptUrl = function (url) {
        url = url.replace(Util.getCtxPath(), Util.getCtxPath() + "/js");
        var splitUrls = url.split("\\/");
        var scriptUrl = "";
        $.each(splitUrls, function (index, obj) {
            if (index == (splitUrls.length - 1)) {
                obj = obj.replace(".htm", ".js");
                scriptUrl += obj;
            } else {
                scriptUrl += (obj + "/");
            }
        });
        return scriptUrl;
    }

    return {
        initApp: function () {
            $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
        },
        loadContent: function (url, _a) {
            var $a = $(_a);
            var _parentA = $a.parent().parent().parent().find("a:first");
            var menusetId = $(_parentA).data("menusetId");
            var menusetName = $(_parentA).data("menusetName");
            var menuId = $a.data("menuId");
            var menuName = $a.data("menuName");
            $.ajax({
                type: "get",
                url: url,
                cache: false,
                success: function (resp) {
                    $("#menu_name").html(menuName);
                    $("#menuset_name").html(menusetName);
                    $("#path_menu_name").html(menuName);
                    $content.html(resp);
                    $.getScript(getScriptUrl(url));
                    if (!$a.parent().hasClass("active")) {
                        $(".treeview-menu > li").removeClass("active");
                        $a.parent().addClass("active");
                    }
                }
            });
        },
        getContentWrapperHeight: function () {
            return $contentWrapper.height();
        },
        getContentHeight: function () {
            var contentWrapperHeight = this.getContentWrapperHeight();
            var contentHeaderHeight = $contentHeader.height();
            return contentWrapperHeight - contentHeaderHeight;
        }
    }

}();

$(function () {
    HyChat.initApp();
});