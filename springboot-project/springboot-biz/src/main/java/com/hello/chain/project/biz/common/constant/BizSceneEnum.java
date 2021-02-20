package com.hello.chain.project.biz.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务场景
 * @author way
 * @since 2020-03-24
 */
@Getter
@AllArgsConstructor
public enum BizSceneEnum {

    ALLOCATE(10, "调拨"),

    PURCHASE(20, "采购"),
    ;

    private Integer code;
    private String desc;

}
