package huayang.hychat.web;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by buhuayang on 16/7/21.
 */
public class WebContext {

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getResponse();
    }

    public static boolean isAjaxRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attrs == null){
            return false;
        }
        HttpServletRequest request = attrs.getRequest();
        if (request == null){
            return false;
        }
        String requestedWith = request.getHeader("X-Requested-With");
        return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
    }

    public static HttpSession getSession() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest().getSession();
    }

    public static ServletContext getServletContext() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest().getServletContext();
    }

    public static void setSessionAttribute(String key, Object obj) {
        getSession().setAttribute(key, obj);
    }

    public static Object getSessionAttribute(String key) {
        return getSession().getAttribute(key);
    }

    public static void removeSessionAttribute(String key) {
        getSession().removeAttribute(key);
    }

    public static Object getContextAttribute(String key) {
        return getServletContext().getAttribute(key);
    }

    public static void addCookieValue(String key, Object obj) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        HttpServletResponse response = attrs.getResponse();
        String host = request.getServerName();
        Cookie cookie = new Cookie(key, obj == null ? "" : obj.toString());
        cookie.setPath(request.getContextPath() + "/");
        cookie.setDomain(host);
        cookie.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(cookie);
    }

    public static void addCookieValue(String key, Object obj, int maxAge) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        HttpServletResponse response = attrs.getResponse();
        String host = request.getServerName();
        Cookie cookie = new Cookie(key, obj == null ? "" : obj.toString());
        cookie.setPath(request.getContextPath() + "/");
        cookie.setDomain(host);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static void removeCookie(String key) {
        String cookieVal = getCookieValue(key);
        if (cookieVal != null) {
            ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attrs.getRequest();
            HttpServletResponse response = attrs.getResponse();
            String host = request.getServerName();
            Cookie cookie = new Cookie(key, "");
            cookie.setPath(request.getContextPath() + "/");
            cookie.setDomain(host);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    public static String getCookieValue(String key) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Cookie[] cookies = attrs.getRequest().getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (key.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

}
