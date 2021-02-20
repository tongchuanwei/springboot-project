package com.hello.way.project.biz.common.result;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @param <T>
 * @author way
 */
public class Result<T> {

    /**
     * 成功标识
     */
    private Boolean success;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;


    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.success = true;
        this.code = code;
        this.msg = message;
        this.data = data;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("success", success)
                .append("code", code)
                .append("msg", msg)
                .append("data", data)
                .toString();
    }
}
