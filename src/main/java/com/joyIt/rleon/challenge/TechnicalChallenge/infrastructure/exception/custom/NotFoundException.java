package com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception.custom;

import com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception.UnrecoverableException;

import static com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception.enums.CommonEnumException.NOT_FOUND_ERROR;

import lombok.Getter;

@Getter
public class NotFoundException extends UnrecoverableException {

    public NotFoundException() {
        super(NOT_FOUND_ERROR.errorCode, NOT_FOUND_ERROR.errorDescription);
    }
}
