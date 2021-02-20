package com.hello.chain.project.biz.common.rpc;


import com.hello.chain.project.biz.common.exception.BaseException;

/**
 * @author way
 */
public class ResultUtils {

    public static  <T> Result<T> successResult(T data){

        Result<T> result = new Result<>();
        result.setData(data);
        result.setSuccess(true);

        return result;
    }

    public static  <T> Result<T> failResult(Integer code, String message){

        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(message);

        return result;
    }

    public static  <T> Result<T> failResult(BaseException baseExcepion){

        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setCode(baseExcepion.getCode());
        result.setMsg(baseExcepion.getMessage());

        return result;
    }


}
