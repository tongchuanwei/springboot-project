package com.demo.way.project.biz.common.context;

/**
 * 通用业务上下文
 * @author way
 * @since 2020-01-07
 */
public class BizContext extends Context {

    private static final String CONTEXT_KEY_BOS_USER_INFO         =   "bos_user";
    private static final String CONTEXT_KEY_ADMIN_USER_INFO       =   "admin_user";

    /**
     * 设置BOS用户信息
     */
    public static void setBosUserInfo() {
        current().put(CONTEXT_KEY_BOS_USER_INFO, null);
    }

    /**
     * 获取BOS用户信息
     * @return
     */
    public static Object getBosUserInfo() {
        return current().get(CONTEXT_KEY_BOS_USER_INFO);
    }

    /**
     * 设置Admin用户信息
     */
    public static void setAdminUserInfo() {
        current().put(CONTEXT_KEY_ADMIN_USER_INFO, null);
    }

    /**
     * 获取Admin用户信息
     * @return
     */
    public static Object getAdminUserInfo() {
        return current().get(CONTEXT_KEY_ADMIN_USER_INFO);
    }

}
