package com.fss.hystriximpl.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
 * This service exception class used for to catch all the exceptions from service layer during Runtime
 */
@Getter
@Setter
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String responseCode;
    private final String responseMessage;

}
