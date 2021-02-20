package com.hello.way.project.biz.common.constant;

/**
 * @author way
 */
public enum BizCodeEnum {


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

    /********************************
     * 基本异常,无法细分,尽量少用 100000～100999
     *********************************/
    PARAM_INVALID(250100000,"参数不合法"),
    USER_UN_LOGIN(250100001,"用户未登录"),
    NO_ACCESS_PERMISSION (250100002,"没有访问权限"),
    RPC_FAIL(250100003, "外部接口访问异常");


    /********************************
     * application层 101000～101999
     *********************************/


    /********************************
     * domain层 102000～102999
     *********************************/


    /********************************
     * dependency层 103000～103999
     *********************************/


    /********************************
     * infrastructure层 104000～104999
     *********************************/


    /********************************
     * common层 105000～105999
     *********************************/



    private Integer code;
    private String msg;
    @Override
    public String toString() {
        return msg;
    }

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static BizCodeEnum getType(String msg){
        for(BizCodeEnum result: BizCodeEnum.values()){
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
