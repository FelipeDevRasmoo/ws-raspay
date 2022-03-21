package com.rasmoo.client.raspay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @JsonProperty(value = "dt_creation")
    private LocalDate dtCreation;

}
