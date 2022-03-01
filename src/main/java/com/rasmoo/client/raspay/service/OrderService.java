package com.rasmoo.client.raspay.service;

import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.model.OrderModel;

public interface OrderService {
    OrderModel create(OrderDto orderDto);
}
