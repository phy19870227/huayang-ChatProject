package huayang.hychat.web.controller.user;

import huayang.hychat.common.AppContext;
import huayang.hychat.dao.base.ChatUserMapper;
import huayang.hychat.model.bo.SessionData;
import huayang.hychat.model.dto.DefaultResp;
import huayang.hychat.model.dto.SaveProfileReq;
import huayang.hychat.model.po.ChatUser;
import huayang.hychat.utils.DateUtil;
import huayang.hychat.web.WebContext;
import huayang.hychat.web.WebKey;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by buhuayang on 16/7/30.
 */
@Controller
@RequestMapping(value = "/user")
public class ProfileController {

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private ChatUserMapper chatUserMapper;
    @Resource(name = "configProperties", type = Properties.class)
    private Properties configProperties;

    @RequestMapping(value = "/profile.htm", method = RequestMethod.GET)
    public String profile() {
        return "user/profile";
    }

    @RequestMapping(value = "/profile.htm", method = RequestMethod.POST)
    @ResponseBody
    public DefaultResp profile(SaveProfileReq req, Model model) {
        try {
            SessionData sessionData = (SessionData) WebContext.getSessionAttribute(WebKey.SESSION_DATA_KEY);
            ChatUser chatUser = sessionData.getChatUser();
            if (req.getHeadImg() != null) {
                MultipartFile headImgFile = req.getHeadImg();
                String physicsPath = configProperties.getProperty("file.physics.path", "");
                String urlPrefix = configProperties.getProperty("file.visit.prefix", "");
                if (StringUtils.isNotBlank(physicsPath) && StringUtils.isNotBlank(urlPrefix)) {
                    String suffix = headImgFile.getOriginalFilename().substring(headImgFile.getOriginalFilename().lastIndexOf(".")).toLowerCase();
                    String fileName = chatUser.getUserFlow() + "-" + DateUtil.getCurrDatetime() + suffix;
                    File parentFile = new File(physicsPath + AppContext.HEAD_IMG_PATH);
                    if(!parentFile.exists()){
                        parentFile.mkdirs();
                    }
                    File targetFile = new File(parentFile, fileName);
                    headImgFile.transferTo(targetFile);

                    chatUser.setHeadImgUrl(urlPrefix + AppContext.HEAD_IMG_PATH + fileName);

                    chatUserMapper.updateByPrimaryKeySelective(chatUser);
                } else {
                    DefaultResp resp = WebContext.createResp(DefaultResp.class, "fail.save.profile.headimg");
                    logger.error(resp.getResultMsg());
                    return resp;
                }
            }

            DefaultResp resp = WebContext.createResp(DefaultResp.class, "");
            return resp;
        } catch (Exception e) {
            DefaultResp resp = WebContext.createResp(DefaultResp.class, "fail.save.profile.headimg");
            logger.error(resp.getResultMsg(), e);
            return resp;
        }
    }

}
