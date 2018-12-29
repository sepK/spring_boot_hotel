package com.ecjtu.kongtao.exception;

public class RoomHasOrderException extends RuntimeException{
    public RoomHasOrderException(String message) {
        super(message);
    }

    public RoomHasOrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
