package huayang.hychat.biz.impl;

import huayang.hychat.biz.ILoginBiz;
import huayang.hychat.common.ExampleFactry;
import huayang.hychat.dao.base.ChatUserMapper;
import huayang.hychat.model.po.ChatUser;
import huayang.hychat.model.po.ChatUserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by buhuayang on 16/7/26.
 */
@Service
public class LoginBizImpl implements ILoginBiz {

    private static final Logger logger = LoggerFactory.getLogger(LoginBizImpl.class);

    @Autowired
    private ChatUserMapper chatUserMapper;

    @Override
    public ChatUser getChatUser(String userCode) {
        ChatUser user = new ChatUser();
        user.setUserCode(userCode);
        ChatUserExample example = ExampleFactry.createChatUserExample(user);
        List<ChatUser> users = chatUserMapper.selectByExample(example);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
