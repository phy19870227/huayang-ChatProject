package huayang.hychat.web.controller.chat;

import huayang.hychat.common.GeneralController;
import huayang.hychat.web.WebKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by buhuayang on 16/7/28.
 */
@Controller
@RequestMapping(value = "/chat")
public class ChatRoomController extends GeneralController {

    private static final Logger logger = LoggerFactory.getLogger(ChatRoomController.class);

    @RequestMapping(value = "/chat-room.htm", method = RequestMethod.GET)
    public String chatRoomMain() {
        return "chat/chat-room";
    }

}
