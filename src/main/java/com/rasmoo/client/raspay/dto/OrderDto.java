package com.rasmoo.client.raspay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private String id;

    @JsonProperty("customer_id")
    @NotBlank(message = "customer_id é obrigatório")
    private String customerId;

    @JsonProperty("product_acronym")
    @NotBlank(message = "product_acronym é obrigatório")
    private String productAcronym;

    private BigDecimal discount;
}
