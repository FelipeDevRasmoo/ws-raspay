package com.rasmoo.client.raspay.controller.impl;

import com.rasmoo.client.raspay.controller.OrderController;
import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.model.OrderModel;
import com.rasmoo.client.raspay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/order")
public class OrderControllerImpl implements OrderController {

    private final OrderService orderService;

    @Autowired
    OrderControllerImpl(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderModel> create(@Valid  @RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(orderDto));
    }
}
