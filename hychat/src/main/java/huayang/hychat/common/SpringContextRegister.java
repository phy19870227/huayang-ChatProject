package huayang.hychat.common;

import huayang.hychat.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextRegister implements ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(SpringContextRegister.class);

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.setApplicationContext(applicationContext);
    }

}
