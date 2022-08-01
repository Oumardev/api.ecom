package com.ecom.api.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {
    private final String message;
    private final HttpStatus HttpStatus;
    private final ZonedDateTime timestamp;

    public ApiException(String message, HttpStatus httpStatus, ZonedDateTime timestamp){
        this.message = message;
        this.HttpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage(){
        return this.message;
    }

    public HttpStatus getHttpStatus(){
        return this.HttpStatus;
    }

    public ZonedDateTime getDateTime(){
        return this.timestamp;
    }
}
