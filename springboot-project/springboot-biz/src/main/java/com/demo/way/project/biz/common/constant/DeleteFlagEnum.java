package com.demo.way.project.biz.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  DeleteFlagEnum {

    /**
     * 已删除
     */
    DELETE(1, "已删除"),
            ;

    private Integer code;
    private String desc;
}
