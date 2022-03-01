package com.rasmoo.client.raspay.service;

import com.rasmoo.client.raspay.dto.CustomerDto;
import com.rasmoo.client.raspay.model.CustomerModel;

public interface CustomerService {

    CustomerModel create(CustomerDto customerDto);
}
