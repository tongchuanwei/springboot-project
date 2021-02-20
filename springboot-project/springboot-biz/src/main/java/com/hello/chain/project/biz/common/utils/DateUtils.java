package com.hello.chain.project.biz.common.utils;


import com.hello.chain.project.biz.common.constant.Constants;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * @Author: way
 * @Date: 2019-09-23 17:21
 */
public class DateUtils {


    public static String toString(Date date){
        return DateFormatUtils.format(date, Constants.DATE_DEFAULT_FORMAT);
    }

    public static String toString(Date date, String format){
        return DateFormatUtils.format(date, format);
    }

    public static Date toDate(String str){
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, Constants.DATE_DEFAULT_FORMAT);
        } catch (ParseException e) {
            // add log and throw
            e.printStackTrace();
        }

        return null;
    }
}
