package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.config.SwaggerConfig;
import com.rasmoo.client.raspay.dto.CustomerDto;
import com.rasmoo.client.raspay.model.CustomerModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api(tags = SwaggerConfig.CUSTOMER)
public interface CustomerController {

    @ApiOperation(value = "Cadastrar um novo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Customer criado ou atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição enviada pelo cliente"),
            @ApiResponse(code = 500, message = "Erro interno no serviço"),
    })
    ResponseEntity<CustomerModel> createCustomer(CustomerDto customerDto);
}
