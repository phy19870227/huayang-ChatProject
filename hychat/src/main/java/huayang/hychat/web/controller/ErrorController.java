package huayang.hychat.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by buhuayang on 16/7/26.
 */
@Controller
public class ErrorController {

    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);


    @RequestMapping(value = "/timeout.htm", method = RequestMethod.GET)
    public String timeout(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setStatus(HttpStatus.PRECONDITION_FAILED.value());
        return "common/error/timeout";
    }

}
