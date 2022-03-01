package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.CustomerDto;
import com.rasmoo.client.raspay.model.CustomerModel;

public class CustomerMapper {

    public static CustomerModel fromDtoToModel(CustomerDto customerDto) {
        return CustomerModel.builder()
                .id(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .telephone(customerDto.getTelephone())
                .build();
    }

    public static CustomerDto fromModelToDto(CustomerModel customerModel) {
        return CustomerDto.builder()
                .id(customerModel.getId())
                .firstName(customerModel.getFirstName())
                .lastName(customerModel.getLastName())
                .email(customerModel.getEmail())
                .telephone(customerModel.getTelephone())
                .build();
    }
}
