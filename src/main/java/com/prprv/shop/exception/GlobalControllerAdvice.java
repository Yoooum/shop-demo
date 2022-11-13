package com.prprv.shop.exception;

import com.prprv.shop.common.ResultUtil;
import com.prprv.shop.common.SendResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.prprv.shop.common.Constant.SYSTEM_ERROR;

/**
 * @author 未確認の庭師
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(RequestException.class)
    public SendResponse<?> requestExceptionHandler(RequestException e) {
        log.error("requestException: " + e.getMessage(), e);
        return ResultUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public SendResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return ResultUtil.error(SYSTEM_ERROR, e.getMessage());
    }
}
