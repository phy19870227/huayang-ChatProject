package huayang.hychat.web.interceptor;

import huayang.hychat.model.bo.SessionData;
import huayang.hychat.web.WebContext;
import huayang.hychat.web.WebKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by buhuayang on 16/7/26.
 */
public class TimeoutInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TimeoutInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SessionData sessionData = (SessionData) WebContext.getSessionAttribute(WebKey.CURR_SESSION_DATA);
        if (sessionData == null) {
            response.sendRedirect(request.getContextPath() + "/timeout.htm");
            return false;
        }
        return true;
    }

}
