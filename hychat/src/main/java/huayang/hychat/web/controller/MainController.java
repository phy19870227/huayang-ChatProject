package huayang.hychat.web.controller;

import huayang.hychat.common.GeneralController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by buhuayang on 16/7/26.
 */
@Controller
public class MainController extends GeneralController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/main.htm", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

}
