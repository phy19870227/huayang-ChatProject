/**
 * Created by buhuayang on 16/7/28.
 */
var HyChat = function () {

    var $contentWrapper = $("div.content-wrapper");
    var $contentHeader = $("section.content-header");
    var $content = $("section.content");

    var initContentWrapperHeight = 0;
    var initContentHeight = 0;

    var $mainHeaderHeadImg = $(".hychat-main-header-head-img");
    var $mainSidebarHeadImg = $(".hychat-main-sidebar-head-img");
    var $mainHeaderUserName = $("#main_header_user_name");
    var $mainSidebarUserName = $("#main_sidebar_user_name");

    var buildScriptUrl = function (url, type) {
        url = url.replace(Util.getCtxPath(), Util.getCtxPath() + "/" + type);
        var splitUrls = url.split("\\/");
        var scriptUrl = "";
        $.each(splitUrls, function (index, obj) {
            if (index == (splitUrls.length - 1)) {
                obj = obj.replace(".htm", "." + type);
                scriptUrl += obj;
            } else {
                scriptUrl += (obj + "/");
            }
        });
        return scriptUrl;
    };

    var loadTitle = function (menu) {
        $("#menu_name").html(menu.menuName);
        $("#menuset_name").html(menu.menusetName);
        $("#path_menu_name").html(menu.menuName);
    };

    var getJs = function (url) {
        $.getScript(buildScriptUrl(url, "js"));
    };

    var getCss = function (url) {
        $("<link>").attr({
            rel: "stylesheet",
            href: buildScriptUrl(url, "css")
        }).appendTo("head");
    };

    var loadContent = function (menu, callback) {
        $.ajax({
            type: "get",
            url: menu.url + "?_=" + new Date(),
            cache: false,
            success: function (resp) {
                loadTitle(menu);
                $content.html(resp);
                getJs(menu.url);
                getCss(menu.url);
                $("#refresh_content").data("currMenu", menu);
                if (callback && typeof callback == "function") {
                    callback();
                }
            }
        });
    };
    
    var bindEvents = function () {
        $("#refresh_content").on("click", function () {
            var menu = $(this).data("currMenu");
            if (menu) {
                loadContent(menu);
            }
        });
    };

    return {
        initApp: function () {
            $.ajaxSetup({
                cache: false,
                statusCode: {
                    404: function () {
                        toastr.error("没有此功能", "系统错误");
                    },
                    500: function () {
                        toastr.error("处理失败", "系统错误");
                    },
                    412: function () {
                        toastr.error("请重新登录系统", "会话过期");
                        window.setTimeout(function () {
                            window.location.href = Util.getCtxPath() + "/timeout.htm";
                        }, 1000);
                    }
                }
            });

            toastr.options = {
                "closeButton": true,
                "debug": false,
                "positionClass": "toast-bottom-right",
                "onclick": null,
                "showDuration": "1000",
                "hideDuration": "2000",
                "timeOut": "3000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };

            // $(document).ajaxStart(function () {
            //     $.blockUI({
            //         message: "<img src='" + Util.getCtxPath() + "/img/loading.gif'/>",
            //         css: {
            //             border: "0",
            //             padding: "0",
            //             backgroundColor: "none"
            //         }
            //     });
            // }).ajaxStop(function () {
            //     window.setTimeout(function () {
            //         $.unblockUI();
            //     }, 1000);
            // });

            initContentWrapperHeight = this.getContentWrapperHeight();
            initContentHeight = this.getContentHeight();

            bindEvents();
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
            $("#refresh_content").trigger("click");
        },
        refreshHeader: function (chatUser) {
            $mainHeaderHeadImg.attr("src", chatUser.headImgUrl);
            $mainHeaderUserName.html(chatUser.userName);
        },
        refreshSidebar: function (chatUser) {
            $mainSidebarHeadImg.attr("src", chatUser.headImgUrl);
            $mainSidebarUserName.html(chatUser.userName);
        },
        blockUI: function () {
            $.blockUI({
                message: "<img src='" + Util.getCtxPath() + "/img/loading.gif'/>",
                css: {
                    border: "0",
                    padding: "0",
                    backgroundColor: "none"
                }
            });
        },
        unblockUI: function () {
            $.unblockUI();
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