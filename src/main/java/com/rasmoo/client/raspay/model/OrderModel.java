package com.rasmoo.client.raspay.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("orders")
@Builder
public class OrderModel implements Serializable {

    @Id
    private String id;
    private CustomerModel customer;
    private BigDecimal originalPrice;
    private BigDecimal discount;
    private LocalDateTime registedOrderDate;
}
