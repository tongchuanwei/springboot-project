package com.hello.chain.project.biz.common.exception;

/**
 * 系统异常bug
 * @author way
 */
public class SystemException extends BizException {

    private static final long serialVersionUID = -4871259737580090665L;

    public SystemException(Integer code, String message) {
        super(code, message);
    }
}
