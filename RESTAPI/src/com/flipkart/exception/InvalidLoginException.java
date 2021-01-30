package com.flipkart.exception;

public class InvalidLoginException extends Exception {

    public String getMessage() {
        String msg = "Username/ password incorrect! Try again ";
        return msg;
    }
}