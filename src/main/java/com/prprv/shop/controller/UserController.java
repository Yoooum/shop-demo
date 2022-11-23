package com.prprv.shop.controller;

import com.prprv.shop.common.ResponseCode;
import com.prprv.shop.common.ResultUtil;
import com.prprv.shop.common.SendResponse;
import com.prprv.shop.exception.RequestException;
import com.prprv.shop.model.dto.UserLoginDTO;
import com.prprv.shop.model.dto.UserRegisterDTO;
import com.prprv.shop.model.entity.User;
import com.prprv.shop.model.vo.UserVO;
import com.prprv.shop.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@Tag(name = "用户")
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Resource
    private UserService userService;


    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public SendResponse<UserVO> login(@RequestBody UserLoginDTO body, HttpServletRequest request) {
        User user = userService.login(body.getEmail(), body.getPassword(), request);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return ResultUtil.success(userVO);
    }

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public SendResponse<Long> register(@RequestBody UserRegisterDTO body) {
        String email = body.getEmail();
        String username = body.getUsername();
        String password = body.getPassword();
        long userId = userService.register(email, username, password);
        return ResultUtil.success(userId);
    }

    @Operation(summary = "获取用户信息")
    @GetMapping("/info")
    public SendResponse<UserVO> getLoginUser(HttpServletRequest request) {
        User user = userService.getLoginUser(request);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return ResultUtil.success(userVO);
    }

    @Operation(summary = "用户登出")
    @PostMapping("/logout")
    public SendResponse<Boolean> logout(HttpServletRequest request) {
        boolean logout = userService.logout(request);
        return ResultUtil.success(logout);
    }

}
