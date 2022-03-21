package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.ProductModel;

public class ProductMapper {

    private ProductMapper(){}

    public static ProductModel fromDtoToModel(ProductDto dto) {
        return ProductModel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .acronym(dto.getAcronym())
                .build();
    }
}
