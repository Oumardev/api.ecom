package com.ecom.api.errors;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiNotFoundExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> ApiNotFoundException(ApiRequestException e){
        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
            e.getMessage(), 
            status,
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException,status);
    }
}
