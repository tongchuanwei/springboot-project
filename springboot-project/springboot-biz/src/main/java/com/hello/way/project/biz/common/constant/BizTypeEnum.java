package com.hello.way.project.biz.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 业务线类型
 * @Author: way
 * @Date: 2019-12-26 11:13
 */
@Getter
@AllArgsConstructor
public enum BizTypeEnum {

    /**
     * 单车
     */
    BIKE(1, "单车"),

    /**
     * 助力车
     */
    POWER_BIKE(2, "助力车"),

    /**
     * 电动车
     */
    ELECTRIC_BIKE(3, "电动车"),

    /**
     * 顺风车
     */
    RENT_BIKE(4,"顺风车"),

    /**
     * 电池
     */
    BATTERY(5,"电池"),
    ;

    private Integer code;
    private String desc;

    private static Map<String, BizTypeEnum> name2EnumMap;
    private static Map<Integer, BizTypeEnum> code2EnumMap;

    static {
        name2EnumMap = Stream.of(BizTypeEnum.values())
                .collect(Collectors.toMap(BizTypeEnum::name, Function.identity()));

        code2EnumMap = Stream.of(BizTypeEnum.values())
                .collect(Collectors.toMap(BizTypeEnum::getCode, Function.identity()));
    }

    public static BizTypeEnum getEnumByName(String name){
        return name2EnumMap.get(name);
    }

    public static BizTypeEnum getEnumByName(Integer code){
        return code2EnumMap.get(code);
    }

}
