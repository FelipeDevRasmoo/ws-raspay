package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.CustomerDto;
import com.rasmoo.client.raspay.model.CustomerModel;

public class CustomerMapper {

    private CustomerMapper(){}

    public static CustomerModel fromDtoToModel(CustomerDto dto) {
        return CustomerModel.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .telephone(dto.getTelephone())
                .build();
    }

    public static CustomerModel fromModelToModel(CustomerModel model) {
        return CustomerModel.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .email(model.getEmail())
                .telephone(model.getTelephone())
                .build();
    }

    public static CustomerDto fromModelToDto(CustomerModel model) {
        return CustomerDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .email(model.getEmail())
                .telephone(model.getTelephone())
                .build();
    }
}
