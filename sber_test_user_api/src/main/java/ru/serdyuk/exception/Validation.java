package ru.serdyuk.exception;

public class Validation extends Exception{
    private String message;

    public Validation(String message) {

    }

    public String getMessage() {
        return message;
    }
}
