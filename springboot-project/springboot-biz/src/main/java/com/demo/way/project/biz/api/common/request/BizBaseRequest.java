package com.demo.way.project.biz.api.common.request;

import com.demo.way.project.biz.common.constant.BizSceneEnum;
import com.demo.way.project.biz.common.constant.BizTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务操作参数基类
 */
@Getter
@Setter
public class BizBaseRequest extends BaseRequest {

    /**
     * 业务线
     * @see BizTypeEnum
     */
    private Integer bizType;
    /**
     * 业务唯一ID
     */
    private String bizId;
    /**
     * 场景
     * @see BizSceneEnum
     */
    private Integer scene;
    /**
     * 子场景
     * @see BizSceneEnum
     */
    private Integer subScene;
}
