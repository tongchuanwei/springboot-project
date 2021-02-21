package com.demo.way.project.biz.domain.order.convert;

import com.demo.way.project.biz.domain.order.entity.OrderEntity;
import com.demo.way.project.biz.domain.order.vo.OrderVO;
import com.demo.way.project.biz.infrastructure.dao.model.order.OrderDO;
import org.springframework.beans.BeanUtils;

public class UserConvert {
    public static OrderEntity convertVO2Entity(OrderVO orderVO) {
        OrderEntity entity = new OrderEntity();
        BeanUtils.copyProperties(orderVO,entity);
        return entity;
    }

    public static OrderDO convertVO2DO(OrderVO orderVO) {
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(orderVO,orderDO);
        return orderDO;
    }
}
