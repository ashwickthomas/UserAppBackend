package com.fullstackexample2.fullstackbackend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {

        super("User with id " + " "+id +" "+"doesn't exist");
    }
}
