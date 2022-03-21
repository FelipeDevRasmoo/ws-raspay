package com.rasmoo.client.raspay.service.impl;

import com.rasmoo.client.raspay.dto.CustomerDto;
import com.rasmoo.client.raspay.exception.BusinessException;
import com.rasmoo.client.raspay.mapper.CustomerMapper;
import com.rasmoo.client.raspay.model.CustomerModel;
import com.rasmoo.client.raspay.repository.CustomerRepository;
import com.rasmoo.client.raspay.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerModel create(CustomerDto customerDto) {
        Optional<CustomerModel> customerEmailOpt = customerRepository.findByEmail(customerDto.getEmail());
        if (customerEmailOpt.isPresent()) {
            return CustomerMapper.fromModelToModel(customerEmailOpt.get());
        }
        return customerRepository.save(CustomerMapper.fromDtoToModel(customerDto));
    }
}
