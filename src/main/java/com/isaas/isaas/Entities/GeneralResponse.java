package com.isaas.isaas.Entities;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

public class GeneralResponse<T,V> {

    private Object status = HttpStatus.OK;

    private T data;

    private V additional;

    private String message;

    public GeneralResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public GeneralResponse(T data, V additional, String message) {
        this.data = data;
        this.additional = additional;
        this.message = message;
    }

    public V getAdditional() {
        return additional;
    }

    public void setAdditional(V additional) {
        this.additional = additional;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
