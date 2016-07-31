/**
 * Created by buhuayang on 16/7/28.
 */
//# sourceURL=chat-room.js
var ChatRoom = function () {

    var $chatRoomBox = $("#chat-room-box");

    var resizeChatRoomBox = function () {
        var boxHeaderHeight = $chatRoomBox.find(".box-header").height();
        var boxFooterHeight = $chatRoomBox.find(".box-footer").height();
        $chatRoomBox.find(".direct-chat-messages").css("min-height", ((HyChat.getContentHeight() - (boxHeaderHeight + boxFooterHeight)) * 0.85));
    }

    return {
        init: function () {
            resizeChatRoomBox();
            $("#chat-room-box button").on("click", function () {
                WebStomp.publish("/ws/chat/room.htm", $("input[name='message']").val(), function (msg) {
                    console.log("发送消息:" + msg);
                });
            });
            WebStomp.init("/ws/stomp");
            WebStomp.subscribe("/topic/chat/room", function (msg) {
                var resp = msg.body ? msg.body : msg;
                console.log("接收订阅聊天室消息:" + resp);
                
            });
        }
    }

}();

$(function () {
    ChatRoom.init();
});