package huayang.hychat.model.dto;

/**
 * Created by buhuayang on 16/7/21.
 */
public class RegisterReq {

    private String userCode;
    private String userPwd;
    private String repeatUserPwd;

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

    public String getRepeatUserPwd() {
        return repeatUserPwd;
    }

    public void setRepeatUserPwd(String repeatUserPwd) {
        this.repeatUserPwd = repeatUserPwd;
    }
}
