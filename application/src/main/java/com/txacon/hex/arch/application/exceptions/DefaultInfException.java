package com.txacon.hex.arch.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class DefaultInfException extends RuntimeException {

    private ApiError error;

    public String getExceptionMessage() {
        return error != null ? error.getMessageError() : "";
    }


}
