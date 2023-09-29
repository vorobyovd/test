package com.example.testmvc.exceptions;

public class DuplicatePersonException extends RuntimeException {
    public DuplicatePersonException(String message) {
        super(message);
    }
}
