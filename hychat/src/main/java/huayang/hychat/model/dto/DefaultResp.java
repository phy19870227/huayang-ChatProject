package huayang.hychat.model.dto;

import huayang.hychat.common.AppContext;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by buhuayang on 16/7/21.
 */
public class DefaultResp {

    private String resultFlag;
    private String resultMsg;

    public String asUrlParams(boolean isFirst) {
        try {
            StringBuffer urlParams = new StringBuffer();
            if (isFirst) {
                urlParams.append("?");
            } else {
                urlParams.append("&");
            }
            urlParams.append("resultFlag=").append(resultFlag);
            urlParams.append("&");
            urlParams.append("resultMsg=").append(URLEncoder.encode(resultMsg, AppContext.DEFAULT_ENCODING));
            return urlParams.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getResultFlag() {
        return resultFlag;
    }

    public void setResultFlag(String resultFlag) {
        this.resultFlag = resultFlag;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

}
