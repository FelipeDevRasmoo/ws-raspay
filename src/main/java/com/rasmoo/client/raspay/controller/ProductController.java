package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.config.SwaggerConfig;
import com.rasmoo.client.raspay.dto.PaymentDto;
import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.ProductModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(tags = SwaggerConfig.PRODUCT)
public interface ProductController {

    @ApiOperation(value = "Criar novo produto")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Produto com sucesso"),
            @ApiResponse(code = 400, message = "Erro ao criar produto"),
            @ApiResponse(code = 500, message = "Erro interno no serviço"),
    })
    ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto);
}
