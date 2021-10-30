package com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractException extends RuntimeException{
    private final String errorCode;
    private final String errorDescription;
}
