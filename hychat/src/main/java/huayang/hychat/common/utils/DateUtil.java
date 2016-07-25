package huayang.hychat.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by buhuayang on 16/7/25.
 */
public class DateUtil {

    public static final String DATETIME_FORMAT = "yyyyMMddHHmmss";

    public static final String DATE_FORMAT = "yyyyMMdd";

    public static final String TIME_FORMAT = "HHmmss";

    public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(DATETIME_FORMAT);

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static final SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);

    public static String getCurrDatetime() {
        return datetimeFormat.format(new Date());
    }

}
