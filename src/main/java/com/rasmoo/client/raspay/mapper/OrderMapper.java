package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.model.CustomerModel;
import com.rasmoo.client.raspay.model.OrderModel;

import java.time.LocalDateTime;

public class OrderMapper {

    private OrderMapper(){}

    public static OrderModel fromDtoToModel(OrderDto orderDto,CustomerModel customerModel) {
        return OrderModel.builder()
                .id(orderDto.getId())
                .customer(customerModel)
                .originalPrice(orderDto.getOriginalPrice())
                .discount(orderDto.getDiscount())
                .registedOrderDate(LocalDateTime.now())
                .build();
    }

    public static OrderDto fromModelToDto(OrderModel orderModel) {
        return OrderDto.builder()
                .id(orderModel.getId())
                .customerId(orderModel.getCustomer().getId())
                .originalPrice(orderModel.getOriginalPrice())
                .discount(orderModel.getDiscount())
                .build();
    }
}
