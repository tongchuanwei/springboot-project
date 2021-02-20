package com.hello.way.project.biz.common.constant;

/**
 * @author way
 */
public enum ErrorCodeEnum {



    /**
     * 系统异常
     */
    SYSTEM_ERROR(200000005, "系统异常"),
    /*500 < code <= 600, server error*/

    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    UN_KNOW_ERROR(404, "未知异常");


    private Integer code;
    private String msg;
    @Override
    public String toString() {
        return msg;
    }

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static ErrorCodeEnum getType(String msg){
        for(ErrorCodeEnum result: ErrorCodeEnum.values()){
            if(result.msg.equals(msg)){
                return  result;
            }
        }
        return  null;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
