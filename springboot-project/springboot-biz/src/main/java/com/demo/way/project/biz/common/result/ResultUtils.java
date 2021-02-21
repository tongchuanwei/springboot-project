package com.demo.way.project.biz.common.result;


import com.demo.way.project.biz.common.exception.BaseException;
import com.demo.way.project.biz.common.constant.ErrorCodeEnum;

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
    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> Result<T> validateFailed(String message) {
        return new Result<T>(ErrorCodeEnum.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized(T data) {
        return new Result<T>(ErrorCodeEnum.UNAUTHORIZED.getCode(), ErrorCodeEnum.UNAUTHORIZED.getMsg(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden(T data) {
        return new Result<T>(ErrorCodeEnum.FORBIDDEN.getCode(), ErrorCodeEnum.FORBIDDEN.getMsg(), data);
    }

}
