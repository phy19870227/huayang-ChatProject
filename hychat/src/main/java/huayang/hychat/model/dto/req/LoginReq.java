package huayang.hychat.model.dto.req;

/**
 * Created by buhuayang on 16/7/26.
 */
public class LoginReq {
    private String userCode;
    private String userPwd;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
