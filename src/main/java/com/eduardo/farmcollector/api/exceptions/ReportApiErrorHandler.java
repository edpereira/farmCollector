package com.eduardo.farmcollector.api.exceptions;

import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ReportApiErrorHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage badRequestException(IllegalArgumentException ex, WebRequest webRequest) {
        return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage runtimeException(RuntimeException ex, WebRequest webRequest) {
        return new ErrorMessage(ex.getMessage());
    }

}
