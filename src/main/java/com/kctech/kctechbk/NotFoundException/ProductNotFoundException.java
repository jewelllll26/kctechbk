package com.kctech.kctechbk.NotFoundException;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id){
        super("Could not find product with "  + id);
    }
}