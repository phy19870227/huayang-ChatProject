package huayang.hychat.model.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by buhuayang on 16/7/31.
 */
public class SaveProfileReq {

    private String userName;
    private MultipartFile headImg;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MultipartFile getHeadImg() {
        return headImg;
    }

    public void setHeadImg(MultipartFile headImg) {
        this.headImg = headImg;
    }
}
