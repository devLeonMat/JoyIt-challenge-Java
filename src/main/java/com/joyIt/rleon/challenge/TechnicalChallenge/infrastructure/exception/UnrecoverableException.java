package com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception;

import lombok.Getter;

@Getter
public abstract class UnrecoverableException extends AbstractException{
    public UnrecoverableException(String errorCode, String errorDescription) {
        super(errorCode,errorDescription);
    }
}
