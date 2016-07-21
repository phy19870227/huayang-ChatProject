package huayang.hychat.web.controller;

import huayang.common.utils.SpringUtil;
import huayang.hychat.AppContext;
import huayang.hychat.biz.IRegisterBiz;
import huayang.hychat.model.dto.DefaultResp;
import huayang.hychat.model.po.ChatUser;
import huayang.hychat.web.WebKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by buhuayang on 16/7/20.
 */
@Controller
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private IRegisterBiz registerBiz;

    @RequestMapping(value = "/register.htm", method = RequestMethod.GET)
    public String register() {
        return "account/register";
    }

    @RequestMapping(value = "/register.htm", method = RequestMethod.POST)
    public DefaultResp register(HttpServletRequest request) {
        DefaultResp resp = new DefaultResp();
        return resp;
    }

    @RequestMapping(value = "/checkUserCode.htm", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResp checkUserCode(String userCode) {
        DefaultResp resp = new DefaultResp();
        ChatUser searchChatUser = new ChatUser();
        searchChatUser.setUserCode(userCode);
        int count = registerBiz.count(searchChatUser);
        if (count > 0) {
            resp.setResultFlag(AppContext.FLAG_N);
            resp.setResultMsg(SpringUtil.getMessage("userCode.repeat"));
        } else {
            resp.setResultFlag(AppContext.FLAG_Y);
        }
        return resp;
    }

}
