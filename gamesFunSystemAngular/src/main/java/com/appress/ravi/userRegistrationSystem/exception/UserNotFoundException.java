package com.appress.ravi.userRegistrationSystem.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long userid){
        super("Product not found by id " + userid);

    }
}
