package com.kctech.kctechbk.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kctech.kctechbk.NotFoundException.ProductNotFoundException;



@RestControllerAdvice
public class ProductExceptionHandler {
    
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productNotFoundHandler(ProductNotFoundException e){
        return e.getMessage();
    }
}