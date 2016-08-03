package huayang.hychat.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by buhuayang on 16/8/3.
 */
public class PropUtil {

    public static Map<String, String> propToMap(Properties prop) {
        Map<String, String> map = new HashMap<>();
        propToMap(prop, map);
        return map;
    }

    public static void propToMap(Properties prop, Map<String, String> map) {
        for (String name : prop.stringPropertyNames()) {
            map.put(name, prop.getProperty(name));
        }
    }

}
