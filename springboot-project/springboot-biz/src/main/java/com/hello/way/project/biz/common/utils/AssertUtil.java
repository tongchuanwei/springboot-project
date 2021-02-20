

package com.hello.way.project.biz.common.utils;


import com.hello.way.project.biz.common.constant.ErrorCodeEnum;
import com.hello.way.project.biz.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author way
 * @date 2019/11/1
 */
public class AssertUtil {

  /**
   * 表达不为真，抛出异常
   *
   * @param expression
   * @param message
   */
  public static void isTrue(boolean expression, String message) {
    checkHandler(!expression, ErrorCodeEnum.CONDITION_FALSE, message);
  }

  /**
   * 表达不为真，抛出异常
   *
   * @param expression
   * @param code
   * @param message
   */
  public static void isTrue(boolean expression, int code, String message) {
    checkHandler(!expression, code, message);
  }

  /**
   * 对象为null，抛出异常
   *
   * @param object
   * @param message
   */
  public static void notNull(Object object, String message) {
    checkHandler(object == null, ErrorCodeEnum.PARAM_NULL, message);
  }

  /**
   * 字符串为空，抛出异常
   *
   * @param strValue
   * @param message
   */
  public static void notBlank(String strValue, String message) {
    checkHandler(StringUtils.isBlank(strValue), ErrorCodeEnum.PARAM_BLANK, message);
  }

  /**
   * 集合为空，抛出异常
   *
   * @param collection
   * @param message
   */
  public static void notEmpty(Collection<?> collection, String message) {
    checkHandler(CollectionUtils.isEmpty(collection), ErrorCodeEnum.PARAM_EMPTY, message);
  }

  /**
   * 满足条件则抛出异常
   *
   * @param satisfaction
   * @param message
   */
  private static void checkHandler(boolean satisfaction, ErrorCodeEnum errorEnum, String message) {
    if (satisfaction) {
      throw new BizException(errorEnum.getCode(), message);
    }
  }

  /**
   * 满足条件则抛出异常
   *
   * @param satisfaction
   * @param message
   */
  private static void checkHandler(boolean satisfaction, int code, String message) {
    if (satisfaction) {
      throw new BizException(code, message);
    }
  }
}