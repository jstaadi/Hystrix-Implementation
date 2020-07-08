package com.fss.hystriximpl.exception;

import lombok.Getter;

@Getter
public enum ExceptionType {

    // @formatter:off
    VALIDATION_FAILED(400, "99", "Service Validation Failed."),
    SYSTEM_ERROR(500, "89", "System Error."),
    FALLBACK_ERROR(500, "90", "Microservice communication error, see System Message for details"),
    SQL_ERROR(500, "89", "SQL Exception Occured.");
    // @formatter:on

    final int errorCode;
    final String responseCode;
    final String defaultMessage;

    private ExceptionType(int errorCode, String responseCode, String defaultMessage) {
        this.errorCode = errorCode;
        this.responseCode = responseCode;
        this.defaultMessage = defaultMessage;
    }

}
