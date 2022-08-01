package com.ecom.api.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@ControllerAdvice
public class ApiNotFoundExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiNotFoundRequestException(ApiRequestException e){
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
            e.getMessage(), 
            HttpStatus.NOT_FOUND, 
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        // 2. Return reponse entity
        return new ResponseEntity<>(apiException,badRequest);
    }   
}
