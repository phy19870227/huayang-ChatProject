package huayang.hychat.biz.impl;

import huayang.hychat.biz.IRegisterBiz;
import huayang.hychat.utils.DateUtil;
import huayang.hychat.utils.PasswordUtil;
import huayang.hychat.utils.PkUtil;
import huayang.hychat.dao.base.ChatUserMapper;
import huayang.hychat.model.po.ChatUser;
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
    public void register(ChatUser user) {
        user.setUserFlow(PkUtil.getUUID());
        user.setRegDatetime(DateUtil.getCurrDatetime());
        user.setUserPwd(PasswordUtil.encryptPassword(user.getUserFlow(), user.getUserPwd()));
        chatUserMapper.insertSelective(user);
    }

    @Override
    public ChatUser readUser(String userFlow) {
        return chatUserMapper.selectByPrimaryKey(userFlow);
    }

}
