package com.joyIt.rleon.challenge.TechnicalChallenge.infrastructure.exception.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommonEnumException {

    NOT_FOUND_ERROR("JYE-101", "The request resource does not exists."),
    ALREADY_EXISTS_ERROR("JYE-102", "The request resource does already exists.");

    public final String errorCode;
    public final String errorDescription;


}
