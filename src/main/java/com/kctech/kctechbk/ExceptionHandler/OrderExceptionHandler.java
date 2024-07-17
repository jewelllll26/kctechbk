package com.kctech.kctechbk.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kctech.kctechbk.NotFoundException.OrderNotFoundException;



@RestControllerAdvice
public class OrderExceptionHandler {
    
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String orderNotFoundHandler(OrderNotFoundException e){
        return e.getMessage();
    }
}