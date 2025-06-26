package com.hexaware.demo.exception;

public class InvalidBookDetailsException extends RuntimeException {
    public InvalidBookDetailsException(String message) {
        super(message);
    }
}
