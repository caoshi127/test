package com.zzuli.library.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hejjon
 * @date 2019/8/20 16:16
 */
public class DateUtil {

    /**
     * 将固定格式的日期字符串转换成java.util.Date对象
     * @param dateStr   指定字符串
     * @return          日期对象
     * @throws ParseException   转换异常
     */
    public static Date getDate(String dateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(dateStr);
    }
}
