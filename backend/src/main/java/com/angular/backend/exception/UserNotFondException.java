package com.angular.backend.exception;

public class UserNotFondException extends RuntimeException {
    public UserNotFondException(String message) {
        super(message);
    }
}
