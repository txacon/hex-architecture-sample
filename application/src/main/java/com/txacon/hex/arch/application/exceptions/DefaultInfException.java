package com.txacon.hex.arch.application.exceptions;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class DefaultInfException extends Exception {

    private final String errorMessage;
    private final List<Object> argumentList;

    public DefaultInfException(String errorMessage) {
        this.errorMessage = errorMessage;
        this.argumentList = new ArrayList<>();
    }

    protected void addArgument(Object argument) {
        this.argumentList.add(argument);
    }

    public String getExceptionMessage() {
        return MessageFormat.format(errorMessage, argumentList.toArray());
    }


}
