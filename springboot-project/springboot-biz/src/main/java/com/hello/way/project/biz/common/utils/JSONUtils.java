package com.hello.way.project.biz.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;

/**
 * @author ：way
 * @date ：Created in 2019-11-26 10:49
 * @description：
 */
public class JSONUtils {

    /**
     * 排除不需要转为
     * @param object
     * @param excludeProperties
     * @return
     */
    public static String toJSONStrExcludeProperties(Object object, String[] excludeProperties) {
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludeFilter = filters.addFilter();
        if (excludeProperties != null && excludeProperties.length > 0) {
            excludeFilter.addExcludes(excludeProperties);
        }
        String jsonStr = JSONObject.toJSONString(object, excludeFilter, SerializerFeature.UseSingleQuotes);
        return jsonStr;
    }
}
