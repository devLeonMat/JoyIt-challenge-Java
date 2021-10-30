package com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception;

import com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception.custom.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessage> handleAnyException(Exception ex) {
        log.error("[ErrorHandler:AnyException] " + ex.getMessage());
        return new ResponseEntity<>(
                ErrorMessage.builder()
                        .errorCode("500")
                        .errorDescription(ex.getMessage())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage notFoundException(NotFoundException ex) {
        log.error("[ErrorHandler:notFoundException] " + ex.getErrorDescription());
        return ErrorMessage.builder()
                .errorCode(ex.getErrorCode())
                .errorDescription(ex.getErrorDescription())
                .build();
    }
}
