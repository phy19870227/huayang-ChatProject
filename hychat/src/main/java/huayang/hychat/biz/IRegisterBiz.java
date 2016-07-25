package huayang.hychat.biz;

import huayang.hychat.model.po.ChatUser;

/**
 * Created by buhuayang on 16/7/21.
 */
public interface IRegisterBiz {

    void register(ChatUser user);

    ChatUser readUser(String userFlow);

}
