/**
 * ShardingUtils.java Copyright 2019 way , all rights reserved. way
 * PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.demo.way.project.biz.common.utils;

import com.demo.way.project.biz.common.exception.BizException;
import com.demo.way.project.biz.common.constant.ErrorCodeEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author way
 * @date 2019/12/26
 */
public class ShardingUtils {

  public static Integer getShardingIdByBizId(String tradeBizId) {
    if (StringUtils.length(tradeBizId) != 31) {
      throw new BizException(ErrorCodeEnum.SYSTEM_ERROR);
    }
    Integer shardingId = Integer
        .valueOf(tradeBizId.substring(tradeBizId.length() - 4));
    return shardingId;
  }

  public static Integer getShardingIdByUserId(Long userId) {
    Integer shardingId = (int) (userId % 2048L);
    return shardingId;
  }

}
