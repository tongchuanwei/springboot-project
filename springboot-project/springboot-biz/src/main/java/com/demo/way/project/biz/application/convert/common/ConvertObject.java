package com.demo.way.project.biz.application.convert.common;


import com.demo.way.project.biz.api.iface.order.dto.OrderDTO;
import com.demo.way.project.biz.api.iface.order.response.OrderResponse;
import com.demo.way.project.biz.domain.order.entity.OrderEntity;
import com.demo.way.project.biz.api.iface.order.request.OrderRequest;
import org.springframework.beans.BeanUtils;

public class ConvertObject {



    public static OrderResponse convertEntity2Response(OrderEntity entity) {
        OrderResponse result = new OrderResponse();
        BeanUtils.copyProperties(entity, result);
        return result;
    }

    public static OrderResponse convertDTO2Response(OrderDTO orderDTO) {
        OrderResponse result = new OrderResponse();
        BeanUtils.copyProperties(orderDTO, result);
        return result;
    }


    public static OrderEntity convertRequest2Entity(OrderRequest request) {
        OrderEntity entity = new OrderEntity();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }

    public static OrderRequest convertDTO2Request(OrderDTO orderDTO) {
        OrderRequest request = new OrderRequest();
        BeanUtils.copyProperties(orderDTO, request);
        return request;
    }

    public static OrderDTO convertEntity2DTO(OrderEntity entity) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(entity, orderDTO);
        return orderDTO;
    }

    public static OrderEntity convertDTO2Entity(OrderDTO orderDTO) {
        OrderEntity entity = new OrderEntity();
        BeanUtils.copyProperties(orderDTO,entity);
        return entity;
    }



}
