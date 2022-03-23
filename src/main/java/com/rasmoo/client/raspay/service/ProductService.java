package com.rasmoo.client.raspay.service;

import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.ProductModel;

import java.util.List;

public interface ProductService {

    ProductModel create(ProductDto dto);

    List<ProductModel> readAll();
}
