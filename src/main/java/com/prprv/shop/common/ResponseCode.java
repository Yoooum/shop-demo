package com.prprv.shop.common;

/**
 * @author 未確認の庭師
 */
public enum ResponseCode {
    SUCCESS(0, "成功"),
    PARAMS_ERROR(4000, "参数错误"),
    NOT_LOGIN(4010, "未登录"),
    NO_AUTH(4011, "无权限"),
    NOT_FOUND(4040, "请求数据不存在"),
    FORBIDDEN(4030, "禁止访问"),
    SYSTEM_ERROR(5000, "系统内部异常"),
    OPERATION_ERROR(5001, "操作失败");

    private final int code;
    private final String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }

}
