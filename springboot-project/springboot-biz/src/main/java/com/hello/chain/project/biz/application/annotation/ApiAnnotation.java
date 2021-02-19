package com.hello.chain.project.biz.application.annotation;

import com.hello.chain.project.biz.application.aop.ApiAspect;
import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see ApiAspect
 * @author way
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Order(1)
public @interface ApiAnnotation {


}