package com.prprv.shop.controller;

import com.prprv.shop.common.ResultUtil;
import com.prprv.shop.common.SendResponse;
import com.prprv.shop.model.dto.UserLoginRequest;
import com.prprv.shop.model.dto.UserRegisterRequest;
import com.prprv.shop.model.entity.User;
import com.prprv.shop.model.vo.UserVO;
import com.prprv.shop.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 未確認の庭師
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public SendResponse<User> login(@RequestBody UserLoginRequest body, HttpServletRequest request) {
        User user = userService.login(body.getEmail(), body.getPassword(), request);
        return ResultUtil.success(user);
    }

    @PostMapping("/register")
    public SendResponse<Long> register(@RequestBody UserRegisterRequest body) {
        String email = body.getEmail();
        String username = body.getUsername();
        String password = body.getPassword();
        long userId = userService.register(email, username, password);
        return ResultUtil.success(userId);
    }

    @GetMapping("/info")
    public SendResponse<UserVO> getLoginUser(HttpServletRequest request) {
        User user = userService.getLoginUser(request);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return ResultUtil.success(userVO);
    }

    @PostMapping("/logout")
    public SendResponse<Boolean> logout(HttpServletRequest request) {
        boolean logout = userService.logout(request);
        return ResultUtil.success(logout);
    }

}
