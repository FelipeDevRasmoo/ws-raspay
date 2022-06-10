package com.rasmoo.client.raspay.service.impl;

import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.exception.BusinessException;
import com.rasmoo.client.raspay.exception.NotFoundException;
import com.rasmoo.client.raspay.mapper.OrderMapper;
import com.rasmoo.client.raspay.mapper.ProductMapper;
import com.rasmoo.client.raspay.model.CustomerModel;
import com.rasmoo.client.raspay.model.OrderModel;
import com.rasmoo.client.raspay.model.ProductModel;
import com.rasmoo.client.raspay.repository.CustomerRepository;
import com.rasmoo.client.raspay.repository.OrderRepository;
import com.rasmoo.client.raspay.repository.ProductRepository;
import com.rasmoo.client.raspay.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository,
                     ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderModel create(OrderDto orderDto) {
        Optional<CustomerModel> customerModelOpt = customerRepository.findById(orderDto.getCustomerId());

        if (customerModelOpt.isEmpty()) {
            throw new NotFoundException("Cliete não encontrado");
        }

        Optional<ProductModel> productModelOpt = productRepository.findByAcronym(orderDto.getProductAcronym().toUpperCase());
        if (productModelOpt.isEmpty()) {
            throw new NotFoundException("Sigla do produto inexistente");
        }
        ProductDto productDto = ProductMapper.fromModelToDto(productModelOpt.get());
        OrderModel orderModel = OrderMapper.fromDtoToModel(orderDto, productDto);
        if (orderDto.getDiscount().intValue() > 0) {
            if (orderDto.getDiscount().compareTo(productModelOpt.get().getCurrentPrice()) > 0) {
                throw new BusinessException("Desconto não pode ser maior que o valor original",HttpStatus.BAD_REQUEST);
            }
            orderModel.setOriginalPrice(productModelOpt.get().getCurrentPrice().subtract(orderDto.getDiscount()));
        }

        return orderRepository.save(orderModel);
    }
}
