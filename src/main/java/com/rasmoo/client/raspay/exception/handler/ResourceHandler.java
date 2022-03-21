package com.rasmoo.client.raspay.exception.handler;

import com.rasmoo.client.raspay.dto.error.ErrorResponseDto;
import com.rasmoo.client.raspay.exception.BusinessException;
import com.rasmoo.client.raspay.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDto> businessExceptionHandler(BusinessException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(), ex.getHttpStatus().value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundExceptionHandler(NotFoundException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> businessExceptionHandler(MethodArgumentNotValidException ex) {
        Map<String, String> messages = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(erro -> {
            String campo = ((FieldError) erro).getField();
            String mensagem = erro.getDefaultMessage();
            messages.put(campo, mensagem);
        });
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(Arrays.toString(messages.entrySet().toArray()), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
    }
}
