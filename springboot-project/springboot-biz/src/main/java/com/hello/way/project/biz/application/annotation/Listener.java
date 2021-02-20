
package com.hello.way.project.biz.application.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 监听器
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Listener {
    /**
     * 优先级
     */
    int priority();
}
