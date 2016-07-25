package huayang.hychat.common.utils;

import java.util.UUID;

public class PkUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getGUID() {
        return UUID.randomUUID().toString();
    }

}
