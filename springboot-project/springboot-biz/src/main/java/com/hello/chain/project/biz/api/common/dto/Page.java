package com.hello.chain.project.biz.api.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page implements Serializable {

  private static final long serialVersionUID = 7997438245500261007L;

  private Integer pageSize = 20;

  private Integer pageNo = 1;

  public static Page init() {
    return new Page();
  }

  public Page pageSize(Integer pageSize) {
    this.setPageSize(pageSize);
    return this;
  }

  public Page pageNo(Integer pageNo) {
    this.setPageNo(pageNo);
    return this;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    if (pageSize > 100) {
      throw new RuntimeException("不允许单页超过100条数据");
    }
    this.pageSize = pageSize;
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    if (pageNo > 100) {
      throw new RuntimeException("不允许深度分页超过100页");
    }
    this.pageNo = pageNo;
  }
}
