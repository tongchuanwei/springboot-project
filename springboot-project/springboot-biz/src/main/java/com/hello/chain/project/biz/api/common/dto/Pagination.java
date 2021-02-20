package com.hello.chain.project.biz.api.common.dto;


import lombok.Data;

import java.util.List;

/**
 * @decription 公用分页组件
 */
@Data
public class Pagination<T> {

  /**
   * 返回的数据
   */
  private List<T> data;
  /**
   * 总页数
   */
  private int pageCount = 0;

  /**
   * 总记录数
   */
  private long totalNum = 0L;

  /**
   * 每页数据
   */
  private long pageSize = 0;

  /**
   * 当前页号
   */
  private int pageNo = 1;

  /**
   * 当前页号，冗余字段，用于兼容之前系统
   */
  private int pageIndex = 1;

  public static <T> Pagination<T> createSuccessResult(List<T> data,
                                                      long totalNum, long pageSize, int pageNo) {
    Pagination<T> result = new Pagination<>();
    result.setData(data);
    result.setTotalNum(totalNum);
    result.setPageCount((int) Math.ceil((double) totalNum / pageSize));
    result.setPageNo(pageNo);
    result.setPageSize(pageSize);
    return result;
  }

}

