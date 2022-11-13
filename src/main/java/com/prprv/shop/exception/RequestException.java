package com.prprv.shop.exception;

import com.prprv.shop.common.ResponseCode;

/**
 * @author 未確認の庭師
 */
public class RequestException extends RuntimeException {
    private final int code;

    public RequestException(int code, String message) {
        super(message);
        this.code = code;
    }

    public RequestException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public RequestException(ResponseCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
