package com.demo.way.project.biz.common.context;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 上下文基类
 * 注意：使用该类注意关闭上下文
 * @author way
 * @since 2019-10-24
 */
public class Context {

    /**
     * ThreadLocal对象
     */
    private static final ThreadLocal<Context> CONTEXT_THREAD_LOCAL = ThreadLocal.withInitial(Context::new);
    /**
     * 存储对象的map
     */
    private Map<String, Object> map;

    /**
     * 获取当前map
     * @return
     */
    public Map<String, Object> map() {
        return this.map;
    }

    /**
     * 放到上下文中
     * @param key
     * @param value
     * @return
     */
    public Object put(String key, Object value) {
        return Objects.nonNull(map) ? this.map.put(key, value) : null;
    }

    /**
     * 从上下文中删除
     * @param key
     * @return
     */
    public Object remove(String key) {
        return Objects.nonNull(map) ? this.map.remove(key) : null;
    }

    /**
     * 从上下文中获取
     * @param key
     * @return
     */
    public Object get(String key) {
        return Objects.nonNull(map) ? this.map.get(key) : null;
    }

    /**
     * 获取当前上下文
     * @return
     */
    public static Context current() {
        return CONTEXT_THREAD_LOCAL.get();
    }

    /**
     * 启动上下文
     */
    public static void start() {
        Context context = current();
        context.map = new LinkedHashMap<>();
    }

    /**
     * 关闭上下文
     */
    public static void end() {
        Context context = current();
        context.map = null;
    }
}
