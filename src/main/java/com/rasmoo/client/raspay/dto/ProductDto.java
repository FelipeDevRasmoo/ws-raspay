package com.rasmoo.client.raspay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String id;

    @NotBlank(message = "acronym é obrigatório")
    @Size(min = 6,max = 8)
    private String acronym;

    @NotBlank(message = "name é obrigatório")
    private String name;

    @NotNull
    @JsonProperty("current_price")
    private BigDecimal currentPrice;

    @JsonProperty(value = "dt_creation")
    private LocalDate dtCreation;

}
