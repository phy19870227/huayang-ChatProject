package huayang.hychat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by buhuayang on 16/7/25.
 */
public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String DATETIME_FORMAT = "yyyyMMddHHmmss";

    public static final String DATE_FORMAT = "yyyyMMdd";

    public static final String TIME_FORMAT = "HHmmss";

    public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(DATETIME_FORMAT);

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public static final SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_FORMAT);

    public static String getCurrDatetime() {
        return datetimeFormat.format(new Date());
    }

    public static String getCurrDate() {
        return dateFormat.format(new Date());
    }

    public static String getCurrTime() {
        return timeFormat.format(new Date());
    }

    public static String formatToDatetimeStr(Date date) {
        return datetimeFormat.format(date);
    }

    public static String formatToDateStr(Date date) {
        return dateFormat.format(date);
    }

    public static String formatToTimeStr(Date date) {
        return timeFormat.format(date);
    }

    public static String formatToStr(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static String changeFormat(String sourceStr, String originPattern, String targetPattern) {
        try {
            SimpleDateFormat originFormat = new SimpleDateFormat(originPattern);
            SimpleDateFormat targetFormat = new SimpleDateFormat(targetPattern);
            return targetFormat.format(originFormat.parse(sourceStr));
        } catch (ParseException e) {
            logger.warn("Fail to change '" + sourceStr + "' to '" + targetPattern + "'.", e);
            return sourceStr;
        }
    }

}
