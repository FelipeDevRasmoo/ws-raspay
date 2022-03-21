package com.rasmoo.client.raspay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Document("products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    @Id
    private String id;

    @Indexed(unique = true)
    @Size(min = 6,max = 8)
    private String acronym;

    @NotBlank
    private String name;

    @NotNull
    @JsonProperty("dt_creation")
    private LocalDate dtCreation = LocalDate.now();

}
