package com.taskbook.task3.exception;

public class AstronautNotFoundException extends RuntimeException {
    public AstronautNotFoundException(String message){
        super(message);
    }
}
