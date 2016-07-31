package huayang.hychat.web.controller;

import huayang.hychat.biz.ILoginBiz;
import huayang.hychat.common.GeneralController;
import huayang.hychat.common.utils.PasswordUtil;
import huayang.hychat.model.bo.SessionData;
import huayang.hychat.model.dto.DefaultResp;
import huayang.hychat.model.dto.LoginReq;
import huayang.hychat.model.po.ChatUser;
import huayang.hychat.web.WebContext;
import huayang.hychat.web.WebKey;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by buhuayang on 16/7/25.
 */
@Controller
public class LoginController extends GeneralController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ILoginBiz loginBiz;

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    public String login(String resultCode, Model model) {
        if (StringUtils.isNotBlank(resultCode)) {
            DefaultResp resp = WebContext.createResp(DefaultResp.class, resultCode);
            model.addAttribute(WebKey.RESP_MSG_KEY, resp);
        }
        return "login";
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    public String login(LoginReq req, HttpServletRequest request, Model model) {
        ChatUser user = loginBiz.getChatUser(req.getUserCode());
        if (user != null) {
            String encryptPassword = PasswordUtil.encryptPassword(user.getUserFlow(), req.getUserPwd());
            if (StringUtils.equals(encryptPassword, user.getUserPwd())) {
                HttpSession session = request.getSession(true);
                SessionData sessionData = new SessionData();
                sessionData.setHttpSessionId(session.getId());
                sessionData.setChatUser(user);
                WebContext.sessionDataMap.put(user.getUserCode(), sessionData);
                WebContext.setSessionAttribute(WebKey.SESSION_DATA_KEY, sessionData);
                return "redirect:/main.htm";
            }
        }
        return "redirect:/login-fail.htm?resultCode=fail.login.account.wrong";
    }

    @RequestMapping(value = "/login-fail.htm", method = RequestMethod.GET)
    public String loginFail(String resultCode, Model model) {
        DefaultResp resp = WebContext.createResp(DefaultResp.class, false, resultCode);
        model.addAttribute(WebKey.RESP_MSG_KEY, resp);
        return "login-fail";
    }

    @RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
    public String logout() {
        HttpSession session = WebContext.getSession();
        session.invalidate();
        return "redirect:/login.htm";
    }

}
