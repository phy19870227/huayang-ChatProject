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
        loadContent: function (url) {
            $.ajax({
                type: "get",
                url: url,
                // cache: false,
                beforeSend: function () {

                },
                success: function (resp) {
                    $content.html(resp);
                    $.getScript(getScriptUrl(url));
                },
                error: function () {

                },
                complete: function () {
                    
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

});