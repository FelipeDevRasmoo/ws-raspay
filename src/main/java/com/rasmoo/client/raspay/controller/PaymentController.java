package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.config.SwaggerConfig;
import com.rasmoo.client.raspay.dto.PaymentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api(tags = SwaggerConfig.PAYMENT)
public interface PaymentController {

    @ApiOperation(value = "Processar pagamento")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pagamento realizado com sucesso"),
            @ApiResponse(code = 400, message = "Erro ao processar pagamento"),
            @ApiResponse(code = 401, message = "Pagamento não autorizado"),
            @ApiResponse(code = 500, message = "Erro interno no serviço"),
    })
    ResponseEntity<Boolean> process(@Valid @RequestBody PaymentDto dto);
}
