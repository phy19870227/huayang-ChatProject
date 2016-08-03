package huayang.hychat.web.listener;

import huayang.hychat.common.GeneralEnum;
import huayang.hychat.utils.ClassUtil;
import huayang.hychat.utils.Dom4jUtil;
import huayang.hychat.utils.EnumUtil;
import huayang.hychat.utils.SpringUtil;
import huayang.hychat.model.bo.Menu;
import huayang.hychat.model.bo.Menuset;
import huayang.hychat.web.WebKey;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by buhuayang on 16/7/27.
 */
public class AppInitListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(AppInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        //加载枚举
        _loadEnums(context);
        //加载菜单
        _loadMenus(context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    private void _loadMenus(ServletContext context) {
        try {
            Resource resource = SpringUtil.getResource("classpath:main-sidebar.xml");
            if (resource != null) {
                List<Menuset> menusets = new ArrayList<Menuset>();
                Document menuDoc = Dom4jUtil.createDocument(resource.getFile());
                List<Node> menusetNodes = menuDoc.selectNodes("/root-menu/menuset");
                if (menusetNodes != null) {
                    for (Node menusetNode : menusetNodes) {
                        Element menusetElement = (Element) menusetNode;
                        String menusetId = menusetElement.attributeValue("id");
                        String menusetName = menusetElement.attributeValue("name");
                        String menusetType = menusetElement.attributeValue("type");
                        Menuset menuset = new Menuset(menusetId, menusetName, menusetType);
                        List<Node> menuNodes = menusetElement.selectNodes("./menu");
                        if (menuNodes != null) {
                            List<Menu> menus = new ArrayList<Menu>();
                            for (Node menuNode : menuNodes) {
                                Element menuElement = (Element) menuNode;
                                String menuId = menuElement.attributeValue("id");
                                String menuName = menuElement.attributeValue("name");
                                String menuUrl = menuElement.attributeValue("url");
                                Menu menu = new Menu(menuId, menuName, menuUrl);
                                menus.add(menu);
                            }
                            menuset.setMenus(menus);
                        }
                        menusets.add(menuset);
                    }
                }
                context.setAttribute(WebKey.MAIN_SIDEBAR_KEY, menusets);
            }
        } catch (DocumentException e) {
            logger.error("File 'main-sidebar.xml' is a invalid xml file!", e);
        } catch (IOException e) {
            logger.error("File 'main-sidebar.xml' is not exists!", e);
        }
    }

    private void _loadEnums(ServletContext context) {
        Set<Class<?>> set = ClassUtil.getClasses("huayang.hychat.enums");
        for (Class<?> cls : set) {
            List<GeneralEnum> enumList = (List<GeneralEnum>) EnumUtil.toList((Class<? extends GeneralEnum>) cls);
            context.setAttribute(StringUtils.uncapitalize(cls.getSimpleName()) + "List", enumList);
            for (GeneralEnum genum : enumList) {
                context.setAttribute(StringUtils.uncapitalize(cls.getSimpleName()) + genum.name(), genum);
            }
        }
    }

}
