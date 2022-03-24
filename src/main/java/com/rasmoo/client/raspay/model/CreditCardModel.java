package com.rasmoo.client.raspay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("creditCard")
@Builder
public class CreditCardModel implements Serializable {

    @Id
    private String id;

    @NotBlank
    private String number;

    @NotNull
    private Long cvv;

    @NotNull
    private Long month;

    @NotNull
    private Long year;

    @NotBlank
    private String documentNumber;

    @NotNull
    private Long installments;

    @NotBlank
    private String customerId;
}
