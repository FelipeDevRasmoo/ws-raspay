package com.rasmoo.client.raspay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String id;

    @NotBlank(message = "first_name é obrigatório")
    @JsonProperty(value = "first_name")
    private String firstName;

    @NotBlank(message = "last_name é obrigatório")
    @JsonProperty(value = "last_name")
    private String lastName;

    @Email(message = "email precisa ser válido")
    private String email;

    @Size(max = 11, message = "telephone precisa conter 2 dígitos do DDD + 9 dígitos do número")
    @Size(min = 11, message = "telephone precisa conter 2 dígitos do DDD + 9 dígitos do número")
    @NotBlank(message = "telephone é obrigatório")
    private String telephone;
}
