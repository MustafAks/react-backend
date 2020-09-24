package com.backend.react.common.exception;


public class BaseException extends RuntimeException {

    private ExceptionEnum exceptionEnum;
    private String message;

    public BaseException(String message, ExceptionEnum exceptionEnum) {
        super();
        this.message = message;
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}