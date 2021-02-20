package com.hello.way.project.biz.application.component.mq.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 策略模版
 * @Author: way
 * @Date: 2019-12-30 10:29
 */
@Slf4j
@Component
public class StrategyContext {


    @Autowired
    private List<CallBackListener> callBackListenerList;
    /**
     * 根据processkey 过滤流程模板
     * @param processKey
     * @return
     */
    public CallBackListener doFilter(String processKey){
        return callBackListenerList.stream().filter(callBackListener -> callBackListener.filter(processKey)).findFirst().orElse(null);
    }
}
