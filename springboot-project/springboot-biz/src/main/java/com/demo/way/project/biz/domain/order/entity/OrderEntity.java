package com.demo.way.project.biz.domain.order.entity;

import com.demo.way.project.biz.common.utils.SpringContextHolder;
import com.demo.way.project.biz.infrastructure.dao.mapper.order.ItemMapper;
import com.demo.way.project.biz.infrastructure.dao.mapper.order.OrderMapper;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderEntity {

    private OrderMapper orderMapper;
    private ItemMapper itemMapper;
    public OrderEntity(){
        orderMapper = SpringContextHolder.getBean(OrderMapper.class);
        itemMapper = SpringContextHolder.getBean(ItemMapper.class);
    }
}
