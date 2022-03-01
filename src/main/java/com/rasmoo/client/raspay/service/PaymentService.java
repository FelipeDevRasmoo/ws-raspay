package com.rasmoo.client.raspay.service;

import com.rasmoo.client.raspay.dto.PaymentDto;

public interface PaymentService {
    Boolean process(PaymentDto paymentDto);
}
