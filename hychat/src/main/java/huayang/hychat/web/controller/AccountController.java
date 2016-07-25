package huayang.hychat.web.controller;

import huayang.hychat.biz.IRegisterBiz;
import huayang.hychat.common.GeneralController;
import huayang.hychat.common.utils.SpringUtil;
import huayang.hychat.model.dto.DefaultResp;
import huayang.hychat.model.dto.RegisterReq;
import huayang.hychat.model.po.ChatUser;
import huayang.hychat.web.WebContext;
import huayang.hychat.web.WebKey;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by buhuayang on 16/7/20.
 */
@Controller
public class AccountController extends GeneralController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private IRegisterBiz registerBiz;

    @RequestMapping(value = "/register.htm", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register.htm", method = RequestMethod.POST)
    public String register(RegisterReq registerReq, Model model) {
        try {
            ChatUser user = new ChatUser();
            BeanUtils.copyProperties(user, registerReq);
            registerBiz.register(user);
            return "redirect:/register-success.htm?userFlow=" + user.getUserFlow();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/register-success.htm", method = RequestMethod.GET)
    public String registerSuccess(String userFlow, Model model) {
        ChatUser user = registerBiz.readUser(userFlow);
        DefaultResp resp = WebContext.createResp(DefaultResp.class, true, "register.success");
        model.addAttribute("user", user);
        model.addAttribute(WebKey.RESPONSE_MESSAGE, resp);
        return "register-success";
    }

}
