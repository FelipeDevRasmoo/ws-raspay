package com.rasmoo.client.raspay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardDto {

    @NotBlank(message = "number é obrigatório")
    @Size(max = 16,message = "Cartão inválido")
    @Size(min = 16, message = "Cartão inválido")
    private String number;

    @Size(max = 3,message = "cvv deve conter 3 números")
    @Size(min = 3,message = "cvv deve conter 3 números")
    private Long cvv;

    @Min(value = 1,message = "month não pode ser menor que 1")
    @Max(value = 2,message = "month não pode ser maior que 12")
    private Long month;

    @Size(max = 2,message = "year deve conter 2 números")
    @Size(min = 2,message = "year deve conter 2 números")
    private Long year;

    @Size(min = 11,message = "documentNumber deve conter 11 números")
    @Size(min = 11,message = "documentNumber deve conter 11 números")
    @CPF(message = "CPF precisa ser válido")
    @JsonProperty(value = "document_number")
    private String documentNumber;

    private Long installments;

}
