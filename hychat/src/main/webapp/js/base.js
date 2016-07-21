/**
 * Created by buhuayang on 16/7/20.
 */

var HyChat = function () {
    return {
        init: function () {
            //ajax全局配置
            $.ajaxSetup({
                cache: false,
                statusCode: {
                    404: function() {
                        toastr.error('没有该页面或动作!', '系统错误');
                    },
                    500: function() {
                        toastr.error('服务器处理失败!', '系统错误');
                    }
                }
            });
            //通知插件默认配置
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
        },
        getCtxPath: function () {
            var path = window.location.pathname;
            return path.substring(0, path.substr(1).indexOf('/') + 1);
        }
    }
}();