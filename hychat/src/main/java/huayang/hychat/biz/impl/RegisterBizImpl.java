package huayang.hychat.biz.impl;

import huayang.hychat.biz.IRegisterBiz;
import huayang.hychat.dao.base.ChatUserMapper;
import huayang.hychat.model.po.ChatUser;
import huayang.hychat.model.po.ChatUserExample;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by buhuayang on 16/7/21.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RegisterBizImpl implements IRegisterBiz {

    private static final Logger logger = LoggerFactory.getLogger(RegisterBizImpl.class);

    @Autowired
    private ChatUserMapper chatUserMapper;

    @Override
    public int count(ChatUser chatUser) {
        ChatUserExample example = _createChatUserExample(chatUser);
        return chatUserMapper.countByExample(example);
    }

    private ChatUserExample _createChatUserExample(ChatUser chatUser) {
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