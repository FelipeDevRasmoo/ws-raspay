package com.rasmoo.client.raspay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Document("products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel implements Serializable {

    @Id
    private String id;

    @Indexed(unique = true)
    @Size(min = 6,max = 10)
    private String acronym;

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal currentPrice;

    @NotNull
    @JsonIgnore
    private LocalDate dtCreation = LocalDate.now();

}
