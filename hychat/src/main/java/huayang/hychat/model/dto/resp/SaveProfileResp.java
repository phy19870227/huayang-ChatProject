package huayang.hychat.model.dto.resp;

import huayang.hychat.model.dto.DefaultResp;
import huayang.hychat.model.po.ChatUser;

/**
 * Created by buhuayang on 16/8/4.
 */
public class SaveProfileResp extends DefaultResp {

    private ChatUser chatUser;

    public ChatUser getChatUser() {
        return chatUser;
    }

    public void setChatUser(ChatUser chatUser) {
        this.chatUser = chatUser;
    }
}
