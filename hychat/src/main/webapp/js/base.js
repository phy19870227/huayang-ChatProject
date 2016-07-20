/**
 * Created by buhuayang on 16/7/20.
 */
var HyChat = function () {
    return {
        getCtxPath: function () {
            var path = window.location.pathname;
            return path.substring(0, path.substr(1).indexOf('/') + 1);
        }
    }
}();