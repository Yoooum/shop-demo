package com.prprv.shop.controller;

import com.prprv.shop.common.ResponseCode;
import com.prprv.shop.common.ResultUtil;
import com.prprv.shop.common.SendResponse;
import com.prprv.shop.exception.RequestException;
import com.prprv.shop.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 未確認の庭師
 */
@RestController
@CrossOrigin(origins = "*")
public class VerifyController {
    @Resource
    private UserService userService;

    // http://127.0.0.1:8080/verify?id=46&code=8F86284B5A
    @RequestMapping("/verify")
    public SendResponse<String> verify( Long id, String code) {
        if (userService.verifyID(id, code)) {
            return ResultUtil.success("认证成功");
        }
        throw new RequestException(ResponseCode.VERIFY_CODE_EXPIRED);
    }
}
