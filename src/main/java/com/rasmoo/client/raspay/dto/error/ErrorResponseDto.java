package com.rasmoo.client.raspay.dto.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String messages;
    @JsonProperty("status_code")
    private Integer statusCode;
}
