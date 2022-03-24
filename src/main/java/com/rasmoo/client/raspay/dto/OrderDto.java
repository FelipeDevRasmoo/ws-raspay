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

    @NotBlank(message = "customerId é obrigatório")
    private String customerId;

    @NotBlank(message = "productAcronym é obrigatório")
    private String productAcronym;

    private BigDecimal discount;
}
