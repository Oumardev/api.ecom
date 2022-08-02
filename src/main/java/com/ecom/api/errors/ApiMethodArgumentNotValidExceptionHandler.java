package com.ecom.api.errors;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiMethodArgumentNotValidExceptionHandler {
    
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> ApiMethodArgumentNotValidException(MethodArgumentNotValidException e){

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
            e.getMessage(), 
            httpStatus, 
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException,httpStatus);
    }
}

//org.springframework.web.bind.MethodArgumentNotValidException