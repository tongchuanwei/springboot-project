package com.demo.way.project.biz.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author way
 * @date 2020/3/1
 */
public class DateUtils {

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String FORMAT_MINUTE = "yyyy.MM.dd HH:mm";
    
    private static final String FORMAT_SHORT_DATE = "yyyyMMdd";

    /**
     * @Description: String类型毫秒数转换成日期格式字符串
     * @return String yyyy-MM-dd HH:mm
     */
    public static String stringToDateString(String lo){
        if (StringUtils.isEmpty(lo)) {
            return "";
        }
        long time = Long.parseLong(lo);
        Date date = new Date(time);
        SimpleDateFormat sd = new SimpleDateFormat(FORMAT_MINUTE);
        return sd.format(date);
    }

    /**
     * @Description: Date类型毫秒数转换成日期格式字符串
     * @return String yyyy-MM-dd HH:mm
     */
    public static String dateToString(Date date){
        if (null == date) {
            return "";
        }
        SimpleDateFormat sd = new SimpleDateFormat(FORMAT_MINUTE);
        return sd.format(date);
    }
    
    /**
     * @Description: Date类型毫秒数转换成日期格式字符串
     * @return String yyyyMMdd
     */
    public static String toShortDateString(Date date){
        if (null == date) {
            return "";
        }
        SimpleDateFormat sd = new SimpleDateFormat(FORMAT_SHORT_DATE);
        return sd.format(date);
    }

    public static Date getToday() {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        String result = fmt.format(new Date());
        return formatDate(result);
    }
    /**
     * 格式化日期
     *
     * @return
     */
    public static Date formatDate(String date) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return fmt.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date addNum(Date date,int num){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, num);
        return calendar.getTime();
    }

    public static String date2String(Date date ) {
        DateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date);
    }


}
