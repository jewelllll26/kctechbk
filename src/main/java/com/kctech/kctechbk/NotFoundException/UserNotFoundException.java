package com.kctech.kctechbk.NotFoundException;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Could not found user with" + id);
    }
}