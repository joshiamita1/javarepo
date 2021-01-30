package com.flipkart.exception;

public class CourseNotFoundException extends Exception{
    public String getMessage() {
        String msg="Course does not exist! ";
        return msg;
    }

}
