package com.rasmoo.client.raspay.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Customer deve ser informado no pedido")
    private CustomerModel customer;

    @JsonProperty("original_price")
    private BigDecimal originalPrice;

    private BigDecimal discount;

    @JsonProperty("dt_registed_order=")
    private LocalDateTime dtRegistedOrder;

    @JsonProperty("Product")
    private ProductModel productModel;
}
