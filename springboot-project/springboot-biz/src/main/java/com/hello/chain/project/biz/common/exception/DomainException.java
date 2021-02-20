package com.hello.chain.project.biz.common.exception;


import com.hello.chain.project.biz.common.constant.ErrorCode;

/**
 * @author elvis
 */
public class DomainException extends BaseException {

    private static final long serialVersionUID = 6348468206643311227L;

    public DomainException(Integer code, String message) {
        super(code, message);
    }

    public DomainException(ErrorCode errorCode) {
        super(errorCode);
    }

}
