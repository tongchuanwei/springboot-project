package com.demo.way.project.biz.application.annotation;


import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @see
 * @author way
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Order(1)
public @interface ApiAnnotation {


}