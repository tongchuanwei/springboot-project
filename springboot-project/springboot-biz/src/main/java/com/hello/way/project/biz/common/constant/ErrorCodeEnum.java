package com.hello.way.project.biz.common.constant;

/**
 * @author way
 */
public enum ErrorCodeEnum {


    //参数校验错误码段 1000-00-xxx
    CONDITION_FALSE(100000000, "校验条件为false"),
    PARAM_NULL(100000001, "校验参数为null"),
    PARAM_EMPTY(100000002, "校验参数为空"),
    PARAM_BLANK(100000003, "校验参数为空"),

    NOT_EXITS(200000001, "记录不存在"),
    NOT_SUPPORT(200000002, "暂不支持"),
    VERSION_ERROR(200000003, "数据版本错误"),
    COMPENSATE_ERROR(200000004, "补偿失败"),
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
