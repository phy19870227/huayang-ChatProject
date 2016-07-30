package huayang.hychat.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by buhuayang on 16/7/30.
 */
@Controller
@RequestMapping(value = "/user")
public class ProfileController {

    @RequestMapping(value = "/profile.htm", method = RequestMethod.GET)
    public String profile() {
        return "user/profile";
    }

}
