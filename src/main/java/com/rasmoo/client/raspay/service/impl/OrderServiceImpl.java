package com.rasmoo.client.raspay.service.impl;

import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.exception.BusinessException;
import com.rasmoo.client.raspay.exception.NotFoundException;
import com.rasmoo.client.raspay.mapper.OrderMapper;
import com.rasmoo.client.raspay.model.CustomerModel;
import com.rasmoo.client.raspay.model.OrderModel;
import com.rasmoo.client.raspay.repository.CustomerRepository;
import com.rasmoo.client.raspay.repository.OrderRepository;
import com.rasmoo.client.raspay.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Long UM_ANO = 1L;

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    OrderServiceImpl(OrderRepository orderRepository,CustomerRepository customerRepository){
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public OrderModel create(OrderDto orderDto) {

        Optional<OrderModel> orderModelOpt = orderRepository.findByCustomerId(orderDto.getCustomerId());

        if(orderModelOpt.isPresent()){
            OrderModel orderModelByCustomer = orderModelOpt.get();
            LocalDateTime expired = orderModelByCustomer.getRegistedOrderDate().plusYears(UM_ANO);
            if(LocalDateTime.now().isBefore(expired))
                throw new BusinessException("Usuário já realizou o pagamento e não está no período de renovação", HttpStatus.BAD_REQUEST);
        }
        Optional<CustomerModel> customerModelOpt = customerRepository.findById(orderDto.getCustomerId());
        if (customerModelOpt.isEmpty()){
            throw new NotFoundException("Cliete não encontrado");
        }
        OrderModel orderModel = OrderMapper.fromDtoToModel(orderDto,customerModelOpt.get());
        return orderRepository.save(orderModel);
    }
}
