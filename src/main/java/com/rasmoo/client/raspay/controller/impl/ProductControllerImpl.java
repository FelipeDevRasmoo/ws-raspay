package com.rasmoo.client.raspay.controller.impl;

import com.rasmoo.client.raspay.controller.ProductController;
import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.ProductModel;
import com.rasmoo.client.raspay.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/product")
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    ProductControllerImpl(ProductService productService){
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.create(dto));
    }

}
