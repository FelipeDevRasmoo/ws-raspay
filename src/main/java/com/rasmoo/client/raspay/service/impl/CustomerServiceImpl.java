package com.rasmoo.client.raspay.service.impl;

import com.rasmoo.client.raspay.dto.CustomerDto;
import com.rasmoo.client.raspay.mapper.CustomerMapper;
import com.rasmoo.client.raspay.model.CustomerModel;
import com.rasmoo.client.raspay.repository.CustomerRepository;
import com.rasmoo.client.raspay.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerModel create(CustomerDto customerDto) {
        Optional<CustomerModel>  customerOpt = customerRepository.findByEmail(customerDto.getEmail());

       if (customerOpt.isPresent()){
           return customerOpt.get();
       }

        CustomerModel customerModel = CustomerMapper.fromDtoToModel(customerDto);
        return customerRepository.save(customerModel);
    }
}
