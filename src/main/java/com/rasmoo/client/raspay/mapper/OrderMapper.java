package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.CustomerModel;
import com.rasmoo.client.raspay.model.OrderModel;
import com.rasmoo.client.raspay.model.ProductModel;

import java.time.LocalDateTime;

public class OrderMapper {

    private OrderMapper(){}

    public static OrderModel fromDtoToModel(OrderDto orderDto, ProductDto productDto) {
        return OrderModel.builder()
                .id(orderDto.getId())
                .customerId(orderDto.getCustomerId())
                .originalPrice(productDto.getCurrentPrice())
                .discount(orderDto.getDiscount())
                .dtRegistedOrder(LocalDateTime.now())
                .product(productDto)
                .build();
    }
}
