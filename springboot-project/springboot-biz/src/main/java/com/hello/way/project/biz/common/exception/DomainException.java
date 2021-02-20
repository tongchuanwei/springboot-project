package com.hello.way.project.biz.common.exception;


import com.hello.way.project.biz.common.constant.ErrorCode;

/**
 * @author way
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
