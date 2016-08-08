package huayang.hychat.web.controller;

import huayang.hychat.common.GeneralController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by buhuayang on 16/8/7.
 */
@Controller
public class ModuleController extends GeneralController {

    private static final Logger logger = LoggerFactory.getLogger(ModuleController.class);

    @RequestMapping(value = "/main-header.htm", method = RequestMethod.GET)
    public String mainHeader() {
        return "module/main-header";
    }

    @RequestMapping(value = "/main-sidebar.htm", method = RequestMethod.GET)
    public String mainSidebar() {
        return "module/main-sidebar";
    }

    @RequestMapping(value = "/main-footer.htm", method = RequestMethod.GET)
    public String mainFooter() {
        return "module/main-footer";
    }

}
