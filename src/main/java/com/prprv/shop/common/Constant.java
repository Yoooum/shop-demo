package com.prprv.shop.common;

/**
 * @author 未確認の庭師
 */
public interface Constant {
    /**
     * 通用状态码
     */
    int SUCCESS = 0;
    int FAIL = 1;
    int PARAMS_ERROR = 4000;
    int NOT_LOGIN = 4010;
    int NO_AUTH = 4011;
    int NOT_FOUND = 4040;
    int FORBIDDEN = 4030;
    int SYSTEM_ERROR = 5000;
    int OPERATION_ERROR = 5001;

    /**
     * 通用消息
     */
    String SUCCESS_MSG = "success";
    String FAIL_MSG = "fail";

    /**
     * 用户状态
     */
    String USER_LOGIN_STATUS = "userLoginStatus";
}
