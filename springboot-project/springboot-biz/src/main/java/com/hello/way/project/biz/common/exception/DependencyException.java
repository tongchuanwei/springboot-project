package com.hello.way.project.biz.common.exception;

import com.hello.way.project.biz.common.constant.ErrorCodeEnum;

/**
 * @author way
 */
public class DependencyException extends BaseException {

    private static final long serialVersionUID = -8896538282818830271L;

    public DependencyException(Integer code, String message) {
        super(code, message);
    }

    public DependencyException(ErrorCodeEnum errorCode){
        super(errorCode);
    }

}
