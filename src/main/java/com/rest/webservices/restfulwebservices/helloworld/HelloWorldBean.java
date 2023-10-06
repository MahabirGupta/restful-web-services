package com.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String message) { //create a constructor
        this.message = message;
    }

//    Generate Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    Generate toString method

    @Override
    public String toString() {
        return "HelloWorldBean{" +
               "message='" + message + '\'' +
               '}';
    }
}
