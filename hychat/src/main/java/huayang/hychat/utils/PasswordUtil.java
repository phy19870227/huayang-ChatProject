package huayang.hychat.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;


public class PasswordUtil {

    private static String algorithmName = "md5";
    private static int hashIterations = 2;

    public static String encryptPassword(String salt, String password) {
        String newPassword = new SimpleHash(algorithmName, password, ByteSource.Util.bytes(salt), hashIterations).toHex();
        return newPassword;
    }

}
