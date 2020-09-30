package com.backend.react.common.exception;


public class ExceptionFactory {

    public ExceptionFactory(String unAuthorized, ExceptionEnum authorized) {
    }

    public static void throwException(String message, ExceptionEnum exceptionEnum) {
        throw new BaseException(message, exceptionEnum);
    }
}