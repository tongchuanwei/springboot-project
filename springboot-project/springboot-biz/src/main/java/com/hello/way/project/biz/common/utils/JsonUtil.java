

package com.hello.way.project.biz.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 统一json入口,后续方便调整
 *
 * @author way
 * @date 2019/10/24
 */
public class JsonUtil {

  public static String json2String(Object object) {
    if (null == object) {
      return "";
    }
    return JSON.toJSONString(object);
  }

  public static <T> T json2Object(String jsonString, Class<T> clazz) {
    if (StringUtils.isBlank(jsonString)) {
      return null;
    }
    return JSON.parseObject(jsonString, clazz);
  }

  public static <T> List<T> json2List(String jsonString, Class<T> clazz) {
    if (StringUtils.isBlank(jsonString)) {
      return null;
    }
    return JSONObject.parseArray(jsonString, clazz);
  }
}
