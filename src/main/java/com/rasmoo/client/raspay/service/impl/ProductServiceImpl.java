package com.rasmoo.client.raspay.service.impl;

import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.mapper.ProductMapper;
import com.rasmoo.client.raspay.model.ProductModel;
import com.rasmoo.client.raspay.repository.ProductRepository;
import com.rasmoo.client.raspay.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel create(ProductDto dto) {
        ProductModel model = ProductMapper.fromDtoToModel(dto);
        model.setDtCreation(LocalDate.now());
        return productRepository.save(model);
    }

    @Override
    public List<ProductModel> readAll() {
        return productRepository.findAll();
    }
}
