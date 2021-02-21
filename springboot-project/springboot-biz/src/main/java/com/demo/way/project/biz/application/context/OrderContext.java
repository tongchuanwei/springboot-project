package com.demo.way.project.biz.application.context;
import com.demo.way.project.biz.domain.order.entity.OrderEntity;
import lombok.Data;

@Data
public class OrderContext {

    OrderEntity OrderEntity;
    /**
     * 是否删除，默认false
     */
    private Boolean delete;

    /**
     * 相同时间是否也更新，默认false
     */
    private Boolean sameTimeUpdate;
}
