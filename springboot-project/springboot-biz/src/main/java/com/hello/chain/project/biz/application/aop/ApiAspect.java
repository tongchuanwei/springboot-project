package com.hello.chain.project.biz.application.aop;

import org.springframework.stereotype.Component;

/**
 * @author way
 */
@Component

public class ApiAspect {

    private static final String MDC_TRADE_ID = "INNER_TRACE_ID";
}