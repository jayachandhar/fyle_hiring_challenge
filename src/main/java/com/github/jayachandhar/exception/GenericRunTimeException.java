package com.github.jayachandhar.exception;

public class GenericRunTimeException extends RuntimeException {
    private String errorCode;

    public GenericRunTimeException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
