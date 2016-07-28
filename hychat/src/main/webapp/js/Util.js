/**
 * Created by buhuayang on 16/7/28.
 */
var Util = function () {

    return {
        getCtxPath: function () {
            var path = window.location.pathname;
            return path.substring(0, path.substr(1).indexOf('/') + 1);
        },
        firstCapitalize: function (str) {
            str = str.toLowerCase();
            var f = str.substr(0, 1);
            var o = str.substr(1, str.length);
            f = f.toUpperCase();
            return f + o;
        }
    }

}();