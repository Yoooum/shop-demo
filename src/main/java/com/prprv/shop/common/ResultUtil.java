package com.prprv.shop.common;

import static com.prprv.shop.common.Constant.SUCCESS;
import static com.prprv.shop.common.Constant.SUCCESS_MSG;

/**
 * @author 未確認の庭師
 */
public class ResultUtil {
    /**
     *  成功
     * @param data 数据
     * @return 返回结果
     * @param <T> 泛型
     */
    public static <T> SendResponse<T> success(T data) {
        return new SendResponse<>(SUCCESS, SUCCESS_MSG, data);
    }

    /**
     * 失败，使用枚举消息
     * @param code 状态码
     * @return 返回结果
     */
    public static <T> SendResponse<T> error(ResponseCode code) {
        return new SendResponse<>(code);
    }

    /**
     * 失败，自定义消息
     * @param code 状态码
     * @param message 消息
     * @return 返回结果
     */
    public static <T> SendResponse<T> error(int code, String message) {
        return new SendResponse<>(code, message, null);
    }


}
