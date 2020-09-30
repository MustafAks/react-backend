package com.backend.react.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum ExceptionEnum {


    INTERNAL_SERVER_ERROR("TS-000-0001", HttpStatus.INTERNAL_SERVER_ERROR),


    BAD_REQUEST_MANDATORY("TS-000-0002", HttpStatus.BAD_REQUEST),


    NOT_FOUND("TS-000-0003", HttpStatus.NOT_FOUND),


    CONFLICT("TS-000-0004", HttpStatus.CONFLICT),


    BAD_REQUEST_MISMATCH("TS-000-0005", HttpStatus.BAD_REQUEST),


    FORMAT_FAILURE("TS-000-0006", HttpStatus.BAD_REQUEST),


    UNACCEPTED_PARENT_CHILD_RELATIONSHIP_FAILURE("TS-000-0007", HttpStatus.BAD_REQUEST),


    ALREADY_ADDED_FAILURE("TS-000-0008", HttpStatus.CONFLICT),


    FILE_UPLOAD_LIMIT_FAILURE("TS-000-0009", HttpStatus.BAD_REQUEST),


    LOGIC_ERROR("TS-000-0010", HttpStatus.BAD_REQUEST),

    UN_AUTHORIZED("TS-000-0011", HttpStatus.BAD_REQUEST);

    private String code;
    private HttpStatus httpStatus;

    ExceptionEnum(String code, HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }

}
