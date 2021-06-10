package xyz.myzsl.uedu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author shilin
 */
public class DateUtils {

    //时间格式化
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //日期类型转字符串
    public static String dateToString(Date date) {
        return dateFormat.format(date);
    }

    //字符串转成日期格式
    public static Date stringToDate(String str) {
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
