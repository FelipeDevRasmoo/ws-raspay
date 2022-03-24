package com.rasmoo.client.raspay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    @NotBlank(message = "customerId é obrigatório")
    private String customerId;

    @NotBlank(message = "orderId é obrigatório")
    private String orderId;

    @NotNull(message = "creditCard é obrigatório")
    private CreditCardDto creditCard;
}
