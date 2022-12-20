package com.fullstackexample2.fullstackbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserAdvice{

    private Map<String,String> errorMap = new HashMap<String,String>();

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String>>userNotFoundExceptionHandler(UserNotFoundException userNotFoundException)
    {
        errorMap.put("Error Message",userNotFoundException.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }


}
