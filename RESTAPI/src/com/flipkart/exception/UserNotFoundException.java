package com.flipkart.exception;

public class UserNotFoundException  extends Exception {
    public String getMessage() {
        String msg="No such user exists ! Verify UserID again ";
        return msg;
    }

}
