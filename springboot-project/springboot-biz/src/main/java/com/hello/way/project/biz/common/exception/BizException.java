package com.hello.way.project.biz.common.exception;


import com.hello.way.project.biz.common.constant.ErrorCodeEnum;

/**
 * @author way
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 6348468206643311227L;

    public BizException(Integer code, String message) {
        super(code, message);
    }

    public BizException(ErrorCodeEnum errorCode) {
        super(errorCode);
    }

}
