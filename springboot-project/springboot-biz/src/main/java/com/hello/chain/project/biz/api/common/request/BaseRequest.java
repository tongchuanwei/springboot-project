package com.hello.chain.project.biz.api.common.request;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: way
 * @Date: 2019-09-18 17:50
 */
@Setter
@Getter
public abstract class BaseRequest implements Serializable {

    private static final long serialVersionUID = -5893363188671235046L;

    /**
     * 请求唯一id
     */
    private String requestId;
    
    /**
     * 请求来源应用id
     */
    private String appId;
    /**
     * 请求时间
     */
    private Date reqTime;
    
     public void paramCheck() {
        Preconditions.checkArgument(this.getRequestId() != null, "requestId不能为空");
        Preconditions.checkArgument(this.getAppId() != null, "appId不能为空");
    }
}
