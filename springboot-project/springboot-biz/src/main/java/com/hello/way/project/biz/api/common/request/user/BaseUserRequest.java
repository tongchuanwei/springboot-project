package com.hello.way.project.biz.api.common.request.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: way
 * @Date: 2019-09-18 17:50
 * @Description: 用户信息
 */
@Data
public class BaseUserRequest implements Serializable {

    private static final long serialVersionUID = 5366713849334943150L;

    /**
     * 用户号
     */
    private String userNo;

    /**
     * 用户角色id
     */
    @Deprecated
    private Integer userRole;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String userTel;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "帐号启用状态：0->禁用；1->启用")
    private Integer status;
}
