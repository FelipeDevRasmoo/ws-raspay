package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.config.SwaggerConfig;
import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.model.OrderModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(tags = SwaggerConfig.ORDER)
public interface OrderController {

    @ApiOperation(value = "Cadastrar um novo pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Pedido criado com sucesso"),
            @ApiResponse(code = 400, message = "Erro na requisição do pedido"),
            @ApiResponse(code = 500, message = "Erro interno no serviço"),
    })
    ResponseEntity<OrderModel> create(@Valid @RequestBody OrderDto orderDto);
}
