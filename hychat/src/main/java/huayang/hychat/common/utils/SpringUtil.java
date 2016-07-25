package huayang.hychat.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

public class SpringUtil {

    private static Logger logger = LoggerFactory.getLogger(SpringUtil.class);

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        synchronized (SpringUtil.class) {
            SpringUtil.applicationContext = applicationContext;
            SpringUtil.class.notifyAll();
        }
    }

    public static ApplicationContext getApplicationContext() {
        synchronized (SpringUtil.class) {
            while (applicationContext == null) {
                try {
                    SpringUtil.class.wait(60000);
                } catch (InterruptedException e) {
                    logger.error("getApplicationContext, wait interrupted!", e);
                }
            }
            return applicationContext;
        }
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> cls) {
        return getApplicationContext().getBean(cls);
    }

    public static String getMessage(String code) {
        return getApplicationContext().getMessage(code, null, Locale.CHINA);
    }

    public static Resource getResource(String name) {
        return getApplicationContext().getResource(name);
    }

    public static Resource [] getResources(String name) {
        try {
            return getApplicationContext().getResources(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
