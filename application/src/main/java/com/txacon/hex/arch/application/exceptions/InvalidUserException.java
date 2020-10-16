package com.txacon.hex.arch.application.exceptions;

public class InvalidUserException extends DefaultInfException{

    private static final String USER_NOT_FOUND_MSG = "User data is invalid, invalid check: {} : {}";

    public InvalidUserException(String searchKey, Object value) {
        super(USER_NOT_FOUND_MSG);
        addArgument(searchKey);
        addArgument(value);
    }
}
