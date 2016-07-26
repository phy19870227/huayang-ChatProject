package huayang.hychat.common;

import huayang.hychat.model.po.ChatUser;
import huayang.hychat.model.po.ChatUserExample;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by buhuayang on 16/7/26.
 */
public class ExampleFactry {

    public static ChatUserExample createChatUserExample(ChatUser chatUser) {
        ChatUserExample example = new ChatUserExample();
        ChatUserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(chatUser.getUserCode())) {
            criteria.andUserCodeEqualTo(chatUser.getUserCode());
        }
        if (StringUtils.isNotBlank(chatUser.getUserName())) {
            criteria.andUserNameLike("%" + chatUser.getUserName() + "%");
        }
        example.setOrderByClause("user_name");
        return example;
    }

}
