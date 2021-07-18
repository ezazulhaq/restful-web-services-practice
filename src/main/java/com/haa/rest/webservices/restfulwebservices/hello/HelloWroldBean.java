package com.haa.rest.webservices.restfulwebservices.hello;

public class HelloWroldBean {

    private String message;

    public HelloWroldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWroldBean [message=" + message + "]";
    }

}
