package com.hello.way.project.biz.domain.order.aggre;

import com.hello.way.project.biz.domain.order.entity.OrderEntity;
import lombok.Data;

@Data
public class OrderAggregation {
    private OrderEntity orderEntity;
}
