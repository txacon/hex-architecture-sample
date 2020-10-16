package com.txacon.hex.arch.application.exceptions;

public class InvalidUserException extends DefaultInfException {
    public InvalidUserException(ApiError error) {
        super(error);
    }
}
