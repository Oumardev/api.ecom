package com.ecom.api.errors;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiConstraintViolationExceptionHandler {
    
    @ExceptionHandler(value ={SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<Object> ApiConstraintViolationException(SQLIntegrityConstraintViolationException e){

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ApiException apiException = new ApiException(
            e.getMessage(), 
            httpStatus, 
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException,httpStatus);
    }
}