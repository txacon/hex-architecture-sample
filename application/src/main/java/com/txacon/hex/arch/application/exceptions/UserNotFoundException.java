package com.txacon.hex.arch.application.exceptions;

public class UserNotFoundException extends DefaultInfException {

    private static final String USER_NOT_FOUND_MSG = "User not found with {} : {}";

    public UserNotFoundException(String searchKey, Object value) {
        super(USER_NOT_FOUND_MSG);
        addArgument(searchKey);
        addArgument(value);
    }

}
