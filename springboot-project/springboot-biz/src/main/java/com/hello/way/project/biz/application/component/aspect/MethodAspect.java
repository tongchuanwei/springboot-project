package com.hello.way.project.biz.application.component.aspect;

import com.alibaba.fastjson.JSON;
import com.hello.way.project.biz.application.annotation.MethodListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
@Slf4j
@Order(0)
public class MethodAspect {

    private static final int    logLength    = 500;


    private Object[] getParam(ProceedingJoinPoint joinPoint) {
        return joinPoint.getArgs();
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

    @Around(value = "@annotation(methodListener)")
    public Object process(ProceedingJoinPoint joinPoint, MethodListener methodListener) throws Throwable {

        // 需要方法结束提醒
        boolean warn = true;

        Object result = null;

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = getMethod(joinPoint);
        Object[] param = getParam(joinPoint);

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            log.error("methodListener invoke method = {} exception", method, e);

            List<String> atMobiles = new ArrayList<String>();

            warn = false;
            throw e;
        } finally {
            try {
                log.info("methodListener invoke method = {},param = {}, result = {}", method,
                         param == null ? null : JSON.toJSON(param), result == null ? null : JSON.toJSONString(result));

                if (warn && methodListener.successWarn()) {
                    List<String> atMobiles = new ArrayList<String>();
                }
            } catch (Exception e) {
                log.info("methodListener include not serializable entity exception ", e);
            }
        }
        return result;
    }

    private String buildSuccessMsgText(String title, String className, String method, Object[] param, String result) {

        StringBuffer msg = new StringBuffer();

        msg.append("## 监控事件：" + title + " \n\n");

        msg.append("> ###### **监控服务**：");
        msg.append(className + "." + method + "\n\n");

        msg.append("> ###### **传参**：");
        msg.append(JSON.toJSONString(param) + "\n\n");

        msg.append("> ###### **返回**：");
        msg.append(result + "\n\n");

        return msg.toString();
    }

    private String buildMsgText(String title, String className, String method, Object[] param, Exception e) {

        StringBuffer msg = new StringBuffer();

        msg.append("## 监控事件：" + title + " \n\n");

        msg.append("> ###### **监控服务**：");
        msg.append(className + "." + method + "\n\n");

        msg.append("> ###### **传参**：");
        msg.append(JSON.toJSONString(param) + "\n\n");

        msg.append("> ###### **告警信息**：");
        msg.append(_modifyErrorMsg(JSON.toJSONString(e), logLength) + "\n\n");

        return msg.toString();
    }

    /**
     * 异常信息字符串处理
     * 
     * @param errMsg
     * @return
     */
    private static String _modifyErrorMsg(String errMsg, int msgLength) {
        if (StringUtils.isNotBlank(errMsg)) {
            StringBuffer sb = new StringBuffer();
            String[] msgs = errMsg.split("\n");
            for (int i = 0; i < msgs.length; i++) {
                sb.append(msgs[i]);
            }
            return _handleErrorMsg(sb.toString(), msgLength);
        }
        return errMsg;
    }

    private static String _handleErrorMsg(String errorMsg, int msgLength) {
        if (StringUtils.isNotBlank(errorMsg)) {
            return errorMsg.length() > msgLength ? errorMsg.substring(0, msgLength) + "..." : errorMsg;
        }
        return errorMsg;
    }

}
