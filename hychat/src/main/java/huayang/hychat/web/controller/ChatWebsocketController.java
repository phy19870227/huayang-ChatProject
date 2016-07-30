package huayang.hychat.web.controller;

import huayang.hychat.common.GeneralController;
import huayang.hychat.web.WebKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by buhuayang on 16/7/30.
 */
@Controller
public class ChatWebsocketController extends GeneralController {

    @Autowired
    public SimpMessagingTemplate template;

    @SubscribeMapping("/topic/chat/room")
    public String topicChatRoom() {
        return WebKey.OPER_OK;
    }

    @MessageMapping("/ws/chat/room.htm")
    public void pushChatRoom(String message) {
        template.convertAndSend("/topic/chat/room", message);
    }

}
