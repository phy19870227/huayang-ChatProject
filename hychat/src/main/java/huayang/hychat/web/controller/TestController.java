package huayang.hychat.web.controller;

import huayang.hychat.common.GeneralController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by buhuayang on 16/7/26.
 */
@Controller
public class TestController extends GeneralController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test500.htm")
    public void test500() {
        throw new RuntimeException("测试500页面");
    }

}
