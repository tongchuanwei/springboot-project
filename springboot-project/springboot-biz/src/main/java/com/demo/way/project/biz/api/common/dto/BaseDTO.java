package com.demo.way.project.biz.api.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * @author way
 * @since 2020-03-24
 */
@Getter
@Setter
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 3967631989077451010L;

    /**
     * 唯一ID
     */
    private String guid;
    /**
     * 创建者ID
     */
    private String creator;
    /**
     * 创建者名称
     */
    private String creatorName;
    /**
     * 操作者ID
     */
    private String operator;
    /**
     * 操作者名称
     */
    private String operatorName;
    /**
     * 是否删除（逻辑删除）
     */
    private Boolean isDeleted;
    /**
     * 扩展字段
     */
    private Map<String, Object> extMap;
}
