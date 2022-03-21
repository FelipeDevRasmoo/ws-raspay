package com.rasmoo.client.raspay.service;

import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.ProductModel;

public interface ProductService {

    ProductModel create(ProductDto dto);
}
