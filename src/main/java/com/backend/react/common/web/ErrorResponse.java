package com.backend.react.common.web;

import com.backend.react.common.exception.ExceptionEnum;
import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private ExceptionEnum errorCode;
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(final String message, final ExceptionEnum errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public ExceptionEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ExceptionEnum errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}