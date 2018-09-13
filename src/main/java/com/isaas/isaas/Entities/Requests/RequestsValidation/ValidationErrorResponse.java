package com.isaas.isaas.Entities.Requests.RequestsValidation;

import com.isaas.isaas.Entities.GeneralResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Send Error Response
 * if the request arguments
 * are not valid
 */
@ControllerAdvice
@RestController
public class ValidationErrorResponse extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message="";
        if(ex==null){
            message="No message!";
        } else {
            if(ex.getBindingResult()!=null && ex.getBindingResult().getAllErrors()!=null){
                for(ObjectError error : ex.getBindingResult().getAllErrors()){
                    message+=error.getDefaultMessage()+"\n";
                }
            }
        }
        return new ResponseEntity<Object>(new GeneralResponse(ex.getBindingResult().getAllErrors(),message),status);
    }
}
