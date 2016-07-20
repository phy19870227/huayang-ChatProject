package huayang.hychat.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by buhuayang on 16/7/20.
 */
@Controller
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value = "/register.htm", method = RequestMethod.GET)
    public String register() {
        return "account/register";
    }

    @RequestMapping(value = "/register.htm", method = RequestMethod.POST)
    public String register(HttpServletRequest request) {
        return "";
    }

}
