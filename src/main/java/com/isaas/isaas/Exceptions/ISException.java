package com.isaas.isaas.Exceptions;

public class ISException extends Exception {

    private String message;

    private String causedBy;

    public ISException(String message, String causedBy) {
        this.message = message;
        this.causedBy = causedBy;
    }

    public ISException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCausedBy() {
        return causedBy;
    }

    public void setCausedBy(String causedBy) {
        this.causedBy = causedBy;
    }
}
