package xyz.xiaogai.utils;

import java.util.Date;

public class Utils {
    //Date转换为Long
    public static Long dateToLong(Date date) {
        return date.getTime();
    }

    //Long转换为Date
    public static Date longToDate(Long time) {
        return new Date(time);
    }
}

