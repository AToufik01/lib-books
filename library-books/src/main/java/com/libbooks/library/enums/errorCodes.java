package com.libbooks.library.enums;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum errorCodes {

    NO_CODE(0,NOT_IMPLEMENTED, "No code provided"),
    INCORRECT_CURRENT_PASSWORD(400,BAD_REQUEST, "Incorrect current password"),
    NEW_PASSWORD_DOES_NOT_MATCH(401,UNAUTHORIZED, "New password does not match"),
    ACCOUNT_LOCKED(302,FORBIDDEN, "Account is locked"),
    ACCOUNT_DISABLED(302,FORBIDDEN, "Account is disabled"),
    BAD_CREDENTIALS(401,UNAUTHORIZED, "Bad credentials"),
    ;


    @Getter
    private final int code;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus;


    errorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
