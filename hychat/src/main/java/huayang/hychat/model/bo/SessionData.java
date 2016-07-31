package huayang.hychat.model.bo;

import huayang.hychat.common.utils.DateUtil;
import huayang.hychat.model.po.ChatUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by buhuayang on 16/7/26.
 */
public class SessionData implements HttpSessionBindingListener {

    private static final Logger logger = LoggerFactory.getLogger(SessionData.class);

    private String httpSessionId;

    private ChatUser chatUser;

    public String getRegDatetime() {
        return DateUtil.changeFormat(chatUser.getRegDatetime(), "yyyyMMddHHmmss", "yyyy-MM-dd");
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        logger.info("Create session![sessionId:{};userCode:{}]", httpSessionId, chatUser.getUserCode());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        logger.info("Destroy session![sessionId:{};userCode:{}]", httpSessionId, chatUser.getUserCode());
    }

    public ChatUser getChatUser() {
        return chatUser;
    }

    public void setChatUser(ChatUser chatUser) {
        this.chatUser = chatUser;
    }

    public String getHttpSessionId() {
        return httpSessionId;
    }

    public void setHttpSessionId(String httpSessionId) {
        this.httpSessionId = httpSessionId;
    }
}
