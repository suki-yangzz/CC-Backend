package com.project.cc.ccbackend.config;

import lombok.Getter;

@Getter
public enum ResponseCode {

    SUCCESS(0, "Request handled successfully.");

    private final int code;
    private final String message;

    private ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return code + ": " + message;
    }
}
