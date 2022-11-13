package com.prprv.shop.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 未確認の庭師
 */
@Data
public class SendResponse<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    public SendResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public SendResponse(int code, T data) {
        this(code, "", data);
    }

    public SendResponse(ResponseCode code) {
        this(code.getCode(), code.getMessage(), null);
    }
}
