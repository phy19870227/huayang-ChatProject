/**
 * Created by buhuayang on 16/7/28.
 */
var HyChat = function () {

    var $contentWrapper = $("div.content-wrapper");
    var $contentHeader = $("section.content-header");
    var $content = $("section.content");

    var initContentWrapperHeight = 0;
    var initContentHeight = 0;

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
    };

    var loadContent = function (menu, callback) {
        $.ajax({
            type: "get",
            url: menu.url + "?_=" + new Date(),
            cache: false,
            success: function (resp) {
                $("#menu_name").html(menu.menuName);
                $("#menuset_name").html(menu.menusetName);
                $("#path_menu_name").html(menu.menuName);
                $content.html(resp);
                $.getScript(getScriptUrl(menu.url));
                if (callback && typeof callback == "function") {
                    callback();
                }
            }
        });
    };

    return {
        initApp: function () {
            $.ajaxSetup({
                cache: false,
                statusCode: {
                    404: function() {
                        toastr.error("没有此功能", "系统错误");
                    },
                    500: function() {
                        toastr.error("处理失败", "系统错误");
                    },
                    412: function() {
                        toastr.error("请重新登录系统", "会话过期");
                        window.setTimeout(function () {
                            window.location.href = Util.getCtxPath() + "/timeout.htm";
                        }, 1000);
                    }
                }
            });
            initContentWrapperHeight = this.getContentWrapperHeight();
            initContentHeight = this.getContentHeight();
            $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
        },
        clickMenu: function (_a) {
            var $a = $(_a);
            var url = $a.data("url");
            if (!$a.parent().hasClass("active")) {
                var menu = {};
                var _parentA = $a.parent().parent().parent().find("a:first");
                menu.url = url;
                menu.menusetId = $(_parentA).data("menusetId");
                menu.menusetName = $(_parentA).data("menusetName");
                menu.menuId = $a.data("menuId");
                menu.menuName = $a.data("menuName");
                loadContent(menu, function () {
                    if (!$a.parent().hasClass("active")) {
                        $(".treeview-menu > li").removeClass("active");
                        $a.parent().addClass("active");
                    }
                });
            }
        },
        selectMenu: function (menuId) {
            var $menu = $(".treeview-menu > li > a[data-menu-id='" + menuId + "']");
            if ($menu.length) {
                $.blockUI();
                var menusetId = $menu.data("menusetId");
                $(".treeview > a[data-menuset-id='" + menusetId + "']").trigger("click");
                window.setTimeout(function () {
                    $menu.trigger("click");
                    $.unblockUI();
                }, $.AdminLTE.options.animationSpeed + 100);
            } else {
                toastr.error("没有此功能", "系统错误");
            }
        },
        refreshContent: function () {
            $(".main-header #refresh");
        },
        getInitContentWrapperHeight: function () {
            return initContentWrapperHeight;
        },
        getInitContentHeight: function () {
            return initContentHeight;
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