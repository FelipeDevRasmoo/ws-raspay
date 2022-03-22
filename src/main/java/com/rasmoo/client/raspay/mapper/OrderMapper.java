package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.model.CustomerModel;
import com.rasmoo.client.raspay.model.OrderModel;
import com.rasmoo.client.raspay.model.ProductModel;

import java.time.LocalDateTime;

public class OrderMapper {

    private OrderMapper(){}

    public static OrderModel fromDtoToModel(OrderDto orderDto, CustomerModel customerModel, ProductModel productModel) {
        return OrderModel.builder()
                .id(orderDto.getId())
                .customer(customerModel)
                .originalPrice(productModel.getCurrentPrice())
                .discount(orderDto.getDiscount())
                .dtRegistedOrder(LocalDateTime.now())
                .productModel(productModel)
                .build();
    }
}
