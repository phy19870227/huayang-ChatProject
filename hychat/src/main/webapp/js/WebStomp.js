/**
 * Created by buhuayang on 16/7/30.
 */
var WebStomp = function () {

    var websocketClient = null;
    var websocketConnected = $.Deferred();

    var initWebsocket = function (wsPath, callback) {
        var sockjs = new SockJS(Util.getCtxPath() + wsPath);
        websocketClient = Stomp.over(sockjs);
        websocketClient.heartbeat.outgoing = 10000;
        websocketClient.heartbeat.incoming = 10000;
        websocketClient.connect({}, function (frame) {
            websocketConnected.resolve();
            if (callback) {
                callback();
            }
        });
        websocketClient.onerror = function (evnt) {
            console.log("和服务器通讯产生错误!");
            websocketConnected.reject();
        };
        websocketClient.onclose = function (evnt) {
            console.log("和服务器通讯失去连接!");
            websocketConnected.reject();
        }
    }
    
    return {
        init: function (wsPath) {
            initWebsocket(wsPath);
        },
        subscribe: function (topic, callback) {
            $.when(websocketConnected).done(function () {
                websocketClient.subscribe(topic, function (msg) {
                    if (callback) {
                        callback(msg);
                    }
                });
            });
        },
        publish: function (topic, msg, callback) {
            $.when(websocketConnected).done(function () {
                websocketClient.send(topic, {}, msg);
                if (callback) {
                    callback(msg);
                }
            });
        }
    }

}();