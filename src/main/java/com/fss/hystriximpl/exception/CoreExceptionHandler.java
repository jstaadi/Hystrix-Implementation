package com.fss.hystriximpl.exception;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/*@Slf4j*/
@Log4j2
@RestControllerAdvice
public class CoreExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public final ResponseEntity<ErrorDetails> handleExceptions(ServiceException exception, WebRequest request) {
        log.error(exception.getMessage(), exception);

        HttpStatus mappedHttpStatus = HttpStatus.BAD_REQUEST;

        String message = exception.getResponseCode() + ": " + exception.getMessage();
        ErrorDetails errorDetails = ErrorDetails.from(ExceptionType.VALIDATION_FAILED.getResponseCode(), message);

        return new ResponseEntity<>(errorDetails, mappedHttpStatus);
    }

    @ExceptionHandler(HystrixRuntimeException.class)
    public final ResponseEntity<ErrorDetails> handleFeignExceptions(HystrixRuntimeException feignException, WebRequest request) {
        log.error(feignException.getMessage(), feignException);

        ErrorDetails errorDetails = ErrorDetails.from(ExceptionType.FALLBACK_ERROR.getResponseCode(), ExceptionType.FALLBACK_ERROR.getDefaultMessage(),
                feignException.getMessage());

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception exception, WebRequest request) {
        log.error(exception.getMessage(), exception);

        ErrorDetails errorDetails = ErrorDetails.from(ExceptionType.SYSTEM_ERROR.getResponseCode(), INTERNAL_SERVER_ERROR.toString(),
                exception.getMessage());

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLExceptionError(SQLException exception, WebRequest request) {
        log.error(exception.getMessage(), exception);

        ErrorDetails errorDetails = ErrorDetails.from(ExceptionType.SQL_ERROR.getResponseCode(),
                INTERNAL_SERVER_ERROR.toString(), exception.getMessage());

        return new ResponseEntity<>(errorDetails, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
