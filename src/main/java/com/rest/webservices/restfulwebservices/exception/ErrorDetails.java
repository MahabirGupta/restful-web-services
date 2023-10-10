package com.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

    //timestamp
    private LocalDateTime timeStamp;
    //message
    private String message;
    //details
    private String details;

    public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
