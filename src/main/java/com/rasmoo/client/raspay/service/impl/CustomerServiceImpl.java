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
        Optional<CustomerModel> customerEmailOpt = customerRepository.findByEmail(customerDto.getEmail());
        CustomerModel customer = CustomerMapper.fromDtoToModel(customerDto);
        if (customerEmailOpt.isPresent()) {
            Optional<CustomerModel> customerPhoneOpt = customerRepository.findByTelephone(customerDto.getTelephone());
            if (customerPhoneOpt.isPresent()) {
                if (matchInformations(customerEmailOpt.get().getEmail(),
                        customerEmailOpt.get().getEmail())) {
                    customerDto.setId(customerEmailOpt.get().getId());
                }
            }
        }
        return customerRepository.save(CustomerMapper.fromDtoToModel(customerDto));
    }

    private Boolean matchInformations(String email, String emailVerified) {
        return email.equals(emailVerified);
    }
}
