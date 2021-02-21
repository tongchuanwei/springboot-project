
package com.demo.way.project.biz.application.component.aspect;

import com.demo.way.project.biz.common.constant.ErrorCodeEnum;
import com.demo.way.project.biz.common.exception.BizException;
import com.demo.way.project.biz.common.result.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author way
 * @date 2019/12/18
 */
@Slf4j
@Aspect
@Component
public class RpcInterceptor {


  @Around("execution(public * com.demo.way.application.web..*.*(..)) " +
          "|| execution(public * com.demo.way.application.rpc..*.*(..))")
  public Object execute(ProceedingJoinPoint pjp) throws Throwable {
    // 获取目标方法原始的调用参数
    Object[] args = pjp.getArgs();
    try {
      long startTime = System.currentTimeMillis();
      Object ret = pjp.proceed(args);
      long endTime = System.currentTimeMillis();
      log.info("method:" + pjp.getSignature() + " execute time = " + (endTime - startTime) + " ms");
      return ret;
    } catch (RuntimeException e) {
      if (e instanceof BizException) {
        return ResultUtils.failResult((BizException) e);
      } else {
        log.error(ErrorCodeEnum.UN_KNOW_ERROR.getMsg(), e);
        return ResultUtils.failResult(new BizException(ErrorCodeEnum.UN_KNOW_ERROR.getCode(), e.toString()));
      }
    }
  }
}
