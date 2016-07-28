package huayang.hychat.web.controller;

import com.google.code.kaptcha.Producer;
import huayang.hychat.common.GeneralController;
import huayang.hychat.web.WebContext;
import huayang.hychat.web.WebKey;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by buhuayang on 16/7/21.
 */
@Controller
public class CommonController extends GeneralController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private Producer captchaProducer;

    @RequestMapping(value = "/check.jpg", method = RequestMethod.GET)
    protected String kaptcha(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        // Set to expire far in the past.
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = RandomStringUtils.randomNumeric(4);
        // store the text in the session
        WebContext.setSessionAttribute(WebKey.CHECK_IMG_VAL_KEY, capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }

        return null;
    }

}
