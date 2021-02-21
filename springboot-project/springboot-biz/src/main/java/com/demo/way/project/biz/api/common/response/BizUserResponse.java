package com.demo.way.project.biz.api.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: way
 * @Date: 2019-09-18 17:50
 */
@Data
public class BizUserResponse extends  BaseResponse implements Serializable {

    private static final long serialVersionUID = 182776697642307693L;

    private String userNo;

    private String userName;

    private String userTel;
}
