package com.example.testmvc.exceptions;


public class CityNotFoundException extends RuntimeException {
    public CityNotFoundException(String message)  {
        super(message);
    }
}
