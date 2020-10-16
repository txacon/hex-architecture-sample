package com.txacon.hex.arch.application.exceptions;

public class UserNotFoundException extends DefaultInfException {
    public UserNotFoundException(ApiError error) {
        super(error);
    }
}
