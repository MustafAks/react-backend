package com.backend.react.common.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {

    private ExceptionEnum exceptionEnum;
    private String message;

    public BaseException(String message, ExceptionEnum exceptionEnum) {
        super();
        this.message = message;
        this.exceptionEnum = exceptionEnum;
    }


}