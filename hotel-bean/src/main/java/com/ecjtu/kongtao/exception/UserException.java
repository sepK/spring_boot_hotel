package com.ecjtu.kongtao.exception;

import com.ecjtu.kongtao.utils.ErrorCode;

/**
 * @author sepK
 */
public class UserException extends RuntimeException {
    /***
     * 第一优先级 使用 ErrorCode
     * ErrorCode 错误码
     */
    private ErrorCode errorCode;

    /**
     * 错误额外信息
     */
    private long extra;

    public UserException() {

    }

    public UserException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public long getExtra() {
        return extra;
    }

    public void setExtra(long extra) {
        this.extra = extra;
    }
}
