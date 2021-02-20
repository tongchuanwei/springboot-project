package com.hello.chain.project.biz.application.aop;

import com.alibaba.fastjson.JSON;
import com.hello.chain.project.biz.application.annotation.ApiAnnotation;
import com.hello.chain.project.biz.common.constant.ErrorCode;
import com.hello.chain.project.biz.common.exception.BaseException;
import com.hello.chain.project.biz.common.exception.BizException;
import com.hello.chain.project.biz.common.exception.SystemException;
import com.hello.chain.project.biz.common.result.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import java.lang.reflect.Method;

/**
 * @author way
 */
@Component
@Aspect
@Slf4j
@Order(-1)
public class ApiAspect {


    @Around(value = "@annotation(apiAnnotation)")
    public Object process(ProceedingJoinPoint joinPoint, ApiAnnotation apiAnnotation) throws Throwable {

        Object result = null;

        String method = getMethod(joinPoint);
        Object[] param = getParam(joinPoint);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            log.error("invoke method = {} exception", method, e);

            //deal fail result
            result = wrapperException(e);
        } finally {
            try {
                stopWatch.stop();
                log.info("invoke method = {},costTime={},param = {}, result = {}", method,stopWatch.getTotalTimeMillis(), param == null ? null : JSON.toJSON(param),
                        result == null ? null : JSON.toJSONString(result));
            } catch (Exception e) {
                //ignore
                log.info("handle method ={} exception ",method, e);
            }
        }
        return result;
    }

    /**
     * get request param
     * @param joinPoint
     * @return
     */
    private Object[] getParam(ProceedingJoinPoint joinPoint) {
        return joinPoint.getArgs();
    }

    /**
     * 生成标准响应
     *
     * @param e
     * @return
     */
    private Object wrapperException(Exception e) {
        if (e instanceof BizException) {
            BaseException baseException = (BaseException) e;
            return ResultUtils.failResult(baseException);
        } else if (e instanceof IllegalArgumentException) {
            return ResultUtils.failResult(new BizException(ErrorCode.PARAM_INVALID.getCode(), e.getMessage()));
        } else {
            return ResultUtils.failResult(new SystemException(ErrorCode.SYSTEM_ERROR.getCode(), e.getMessage()));
        }
    }

    /**
     * 拿到方法名
     *
     * @param joinPoint
     * @return
     */
    private String getMethod(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature ms = (MethodSignature) signature;
        Method m = ms.getMethod();
        return m.getName();
    }
}