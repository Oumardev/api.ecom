package com.ecom.api.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiBadRequestionExceptionHandler {
    
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiBadRequestException(ApiRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
            e.getMessage(), 
            HttpStatus.BAD_REQUEST, 
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException,badRequest);
    }
}
