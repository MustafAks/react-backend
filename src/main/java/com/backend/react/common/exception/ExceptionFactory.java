package com.backend.react.common.exception;


public class ExceptionFactory {

    private ExceptionFactory() {
    }

    public static void throwException(String message, ExceptionEnum exceptionEnum) {
        throw new BaseException(message, exceptionEnum);
    }
}