package com.project.cc.ccbackend.config;

import lombok.Getter;

@Getter
public enum ErrorCode {

    DATABASE(1, "A database error has occurred."),
    DUPLICATE_USER(2, "This user already exists.");

    private final int code;
    private final String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
