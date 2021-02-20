package com.hello.way.project.biz.common.constant;

/**
 * @author way
 */
public enum ErrorCodeEnum {

    /**
     * 2501（1~4位） -> 系统（TMS）
     * （5~6位） 00： 通用
     *          01： 需求单
     *          02： 运单
     *          03： 交接单
     *  (7~9位) 自定义
     */
    //
    //

    PARAM_INVALID(250100000,"参数不合法"),
    USER_UN_LOGIN(250100001,"用户未登录"),
    NO_ACCESS_PERMISSION (250100002,"没有访问权限"),
    RPC_FAIL(250100003, "外部接口访问异常"),

    DEMAND_ORDER_SAVE_ERROR(250101001, "需求单创建失败"),
    DEMAND_ORDER_SAVE_QUERY_PRODUCT_ERROR(250101002, "查询资产数据异常"),
    DEMAND_ORDER_COMBINE_NOT_EXIST_ERROR(250101003, "需求单不存在"),
    DEMAND_ORDER_COMBINE_UPDATE_STATUS_ERROR(250101004, "更新需求单状态异常"),
    DEMAND_ORDER_COMBINE_STATUS_ERROR(250101005, "需求单状态不是待分配状态,不允许创建运单"),
    DEMAND_ORDER_SAVE_REPEATED_ERROR(250101006, "已存在相同的bizOrderNo,不允许重复创建"),

    DELIVERY_ORDER_SAVE_ERROR(250102001, "运单创建失败"),

    TRANSFER_ORDER_SAVE_ERROR(250103001, "交接单创建失败"),

    TRANSFER_ORDER_ITEM_SAVE_ERROR(250103002, "包含已经交接完成的商品%s，无法创建交接单"),

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
