package com.rasmoo.client.raspay.controller.impl;

import com.rasmoo.client.raspay.controller.PaymentController;
import com.rasmoo.client.raspay.dto.PaymentDto;
import com.rasmoo.client.raspay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/payment")
public class PaymentControllerImpl implements PaymentController {

    private final PaymentService paymentService;

    @Autowired
    PaymentControllerImpl(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/credit-card/")
    public ResponseEntity<Boolean> process(@Valid @RequestBody PaymentDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.process(dto));
    }

}
