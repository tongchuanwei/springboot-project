package com.demo.way.project.biz.api.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ：way
 * @date ：Created in 2019/11/14 13:58
 * @description：页码通用返回
 */
@Data
@AllArgsConstructor
public class BasePageResponse implements Serializable {

    private static final long serialVersionUID = -7986897911464863320L;

    private Integer pageNum;

    private Integer pageSize;

    private Long totalSize;

    private Boolean hasNextPage;
}
