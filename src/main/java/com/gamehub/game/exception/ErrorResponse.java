package com.gamehub.game.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime occerredOn;
    private String code;
    private String message;

    public ErrorResponse(String message) {
        this.setOccerredOn();
        this.message = message;
    }

    public LocalDateTime getOccerredOn() {
        return occerredOn;
    }

    public void setOccerredOn() {
        this.occerredOn = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

