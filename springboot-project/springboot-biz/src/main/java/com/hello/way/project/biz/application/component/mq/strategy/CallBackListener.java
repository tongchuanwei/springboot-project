package com.hello.way.project.biz.application.component.mq.strategy;

/**
 * 策略接口
 *
 * @Author: way
 * @Date: 2019-12-30 10:16
 */
public interface CallBackListener {

    boolean onMessage(String purchaseId, String flowInstanceId, Integer processStatus);

    /**
     * 根据模板key 过来对应 BPMN 流程
     *
     * @param processorKey
     * @return
     */
    boolean filter(String processorKey);
}
