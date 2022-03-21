package com.rasmoo.client.raspay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("credit_card")
@Builder
public class CreditCardModel implements Serializable {

    @Id
    private String id;

    private String number;

    private Long cvv;

    private Long month;

    private Long year;

    private String documentNumber;

    private Long installments;

    private String customerId;
}
