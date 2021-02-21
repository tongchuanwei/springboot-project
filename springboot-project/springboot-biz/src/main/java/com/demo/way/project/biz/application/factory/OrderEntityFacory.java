package com.demo.way.project.biz.application.factory;

import com.demo.way.project.biz.api.iface.order.request.OrderRequest;
import com.demo.way.project.biz.domain.order.entity.OrderEntity;

public class OrderEntityFacory {


    public static OrderEntity createEntity(OrderRequest request){
        OrderEntity entity = new OrderEntity();
        return entity;
    }
}
