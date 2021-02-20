package com.hello.way.project.biz.common.utils;

import com.alibaba.fastjson.JSON;

/**
 * @author way
 */
public class StringUtils {


    /**
     * 拿到不带双引号的string
     * @param object
     * @return
     */
    public static String getJsonString(Object object){

        if(object == null){
            return null;
        }

        return JSON.toJSON(object).toString();
    }


    public static String getObjStrWithNullDefaultVal(Object o){
        return o == null ? null : o.toString();
    }

    public static String getObjStrWithBlankDefaultVal(Object o){
        return o == null ? "" : o.toString();
    }

}
