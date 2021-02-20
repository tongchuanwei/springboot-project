package com.hello.chain.project.biz.common.exception;


import com.hello.chain.project.biz.common.constant.ErrorCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author way
 */
@Getter
@Setter
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -7106839091554383616L;
    private Integer code;

    private String message;

    public BaseException(Integer code, String message) {
        super(message);

        this.code = code;
        this.message = message;
    }

    public BaseException(ErrorCode errorCode){
        super(errorCode.getMsg());

        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

}
