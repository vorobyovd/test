package com.example.testmvc.exceptions;

public class DuplicateCityException extends RuntimeException {
    public DuplicateCityException(String message)  {
        super(message);
    }
}
