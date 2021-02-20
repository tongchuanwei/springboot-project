package com.hello.chain.project.biz.common.exception;


import com.hello.chain.project.biz.common.constant.ErrorCode;

/**
 * @author way
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 6348468206643311227L;

    public BizException(Integer code, String message) {
        super(code, message);
    }

    public BizException(ErrorCode errorCode) {
        super(errorCode);
    }

}
