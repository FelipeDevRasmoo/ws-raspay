package com.rasmoo.client.raspay.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "Customer deve ser informado no pedido")
    private String customerId;

    private BigDecimal originalPrice;

    private BigDecimal discount;

    @JsonIgnore
    private LocalDateTime dtRegistedOrder;

    @JsonProperty("product")
    private ProductModel productModel;
}
