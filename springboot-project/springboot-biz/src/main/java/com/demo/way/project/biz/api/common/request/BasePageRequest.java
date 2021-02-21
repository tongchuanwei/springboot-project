package com.demo.way.project.biz.api.common.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: way
 * @Date: 2019-09-23 14:15
 */
@Data
public class BasePageRequest implements Serializable {

    private static final long serialVersionUID = 6405454299207200950L;

    /**
     * 页数
     */
    @ApiModelProperty(value = "页数")
    private Integer pageNo = 1;

    /**
     * 每页大小
     */
    @ApiModelProperty(value = "每页大小")
    private Integer pageSize = 20;
}
