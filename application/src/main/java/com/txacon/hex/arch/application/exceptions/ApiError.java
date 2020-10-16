package com.txacon.hex.arch.application.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ApiError {
    ERROR_USER_NOT_FOUND_BY_ID("User not found by id"),
    ERROR_USER_NOT_FOUND_BY_EMAIL("User not found by email"),
    ERROR_USER_IS_NULL("User is null or empty"),
    ERROR_USER_WITHOUT_ID("Error user without id"),
    ERROR_USER_WITHOUT_EMAIL("Error user without email"),
    ERROR_USER_ALLREADY_EXITS("User allready exits");

    @Getter
    private final String messageError;

}
