package com.hello.chain.project.biz.application.annotation;

import java.lang.annotation.*;

/**
 * 操作切面日志注解
 *
 * @author way
 * @date 2019-07-16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface LogAnnotation {
}
