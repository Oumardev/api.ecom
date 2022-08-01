package com.ecom.api.exception;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiArgumentNotValidException {
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Map<String, String> handleApiInvalidArgumentRequestException(MethodArgumentNotValidException e){
       Map<String, String> errorMap = new HashMap<>();

       e.getBindingResult().getFieldErrors().forEach(error ->{
            errorMap.put(error.getField(), error.getDefaultMessage());
       });

       return errorMap;
    }   
}
