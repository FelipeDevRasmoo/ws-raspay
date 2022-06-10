package com.rasmoo.client.raspay.mapper;

import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.ProductModel;

public class ProductMapper {

    private ProductMapper(){}

    public static ProductModel fromDtoToModel(ProductDto dto) {
        return ProductModel.builder()
                .id(dto.getId())
                .name(dto.getName())
                .acronym(dto.getAcronym().toUpperCase())
                .currentPrice(dto.getCurrentPrice())
                .build();
    }

    public static ProductDto fromModelToDto(ProductModel model) {
        return ProductDto.builder()
                .id(model.getId())
                .name(model.getName())
                .acronym(model.getAcronym().toUpperCase())
                .currentPrice(model.getCurrentPrice())
                .build();
    }
}
