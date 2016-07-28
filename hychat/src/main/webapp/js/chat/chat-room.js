/**
 * Created by buhuayang on 16/7/28.
 */
//@ sourceURL=chat-room.js
var ChatRoom = function () {

    var $chatRoomBox = $("#chat-room-box");

    var resizeChatRoomBox = function () {
        var boxHeaderHeight = $chatRoomBox.find(".box-header").height();
        var boxFooterHeight = $chatRoomBox.find(".box-footer").height();
        $chatRoomBox.find(".direct-chat-messages").css("min-height", ((HyChat.getContentHeight() - (boxHeaderHeight + boxFooterHeight)) * 0.85));
    }

    return {
        init: function () {
            console.log(HyChat.getContentHeight());
            resizeChatRoomBox();
        }
    }

}();

$(function () {
    ChatRoom.init();
});