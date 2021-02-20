package com.hello.chain.project.biz.common.exception;

import com.hello.chain.project.biz.common.constant.ErrorCode;

/**
 * @author way
 */
public class DependencyException extends BaseException {

    private static final long serialVersionUID = -8896538282818830271L;

    public DependencyException(Integer code, String message) {
        super(code, message);
    }

    public DependencyException(ErrorCode errorCode){
        super(errorCode);
    }

}
