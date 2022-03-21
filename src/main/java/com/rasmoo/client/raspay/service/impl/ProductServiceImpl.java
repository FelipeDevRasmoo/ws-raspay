package com.rasmoo.client.raspay.service.impl;

import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.mapper.ProductMapper;
import com.rasmoo.client.raspay.model.ProductModel;
import com.rasmoo.client.raspay.repository.ProductRepository;
import com.rasmoo.client.raspay.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel create(ProductDto dto) {
        return productRepository.save(ProductMapper.fromDtoToModel(dto));
    }
}
