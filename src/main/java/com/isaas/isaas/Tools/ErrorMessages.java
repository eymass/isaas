package com.isaas.isaas.Tools;

public enum ErrorMessages {

    EMAIL_ALREADY_REGISTERED("Email is already registered"),
    PHONE_ALREADY_REGISTERED("Phone is already registered"),
    USERNAME_ALREADY_REGISTERED("Username is already registered");

    String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
