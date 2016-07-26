package huayang.hychat.biz;

import huayang.hychat.model.po.ChatUser;

/**
 * Created by buhuayang on 16/7/26.
 */
public interface ILoginBiz {

    ChatUser getChatUser(String userCode);

}
