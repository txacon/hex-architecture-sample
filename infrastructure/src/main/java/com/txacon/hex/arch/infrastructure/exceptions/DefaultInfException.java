package com.txacon.hex.arch.infrastructure.exceptions;

public class DefaultInfException extends Exception{
    public DefaultInfException() {
        super();
    }

    public DefaultInfException(String message) {
        super(message);
    }

    public DefaultInfException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefaultInfException(Throwable cause) {
        super(cause);
    }

    protected DefaultInfException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
