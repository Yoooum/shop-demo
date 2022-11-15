package com.prprv.shop.service.impl;

import com.prprv.shop.common.ResponseCode;
import com.prprv.shop.exception.RequestException;
import com.prprv.shop.mapper.UserMapper;
import com.prprv.shop.model.entity.User;
import com.prprv.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.prprv.shop.common.Constant.USER_LOGIN_STATUS;

/**
 * @author 未確認の庭師
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param email 用户账号
     * @param password 用户密码
     * @param request 请求
     * @return 用户信息
     */
    @Override
    public User login(String email, String password, HttpServletRequest request) {
        User user = userMapper.selectUserByLogin(email, password);
        // 用户不存在或者密码错误
        if (user == null) {
            throw new RequestException(ResponseCode.PARAMS_ERROR, "用户不存在或密码错误");
        }
        // 登录成功
        request.getSession().setAttribute(USER_LOGIN_STATUS, user);
        return user;
    }

    /**
     * 注册
     * @param email 用户账号
     * @param username 用户名
     * @param password 用户密码
     * @return 新用户ID
     */
    @Override
    public long register(String email, String username, String password) {
        User user = userMapper.selectUserByEmail(email);
        // 用户已存在
        if (user != null) {
            throw new RequestException(ResponseCode.PARAMS_ERROR, "用户已存在");
        }
        // 邮箱合法
        if (!email.matches("^[a-z0-9A-Z]+[-|a-z0-9A-Z._]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$")) {
            throw new RequestException(ResponseCode.PARAMS_ERROR, "邮箱格式不合法");
        }
        // 用户名大于 2 位
        if (username.length() < 2) {
            throw new RequestException(ResponseCode.PARAMS_ERROR, "用户名长度不合法");
        }
        // 密码大于 8 位
        if (password.length() < 8) {
            throw new RequestException(ResponseCode.PARAMS_ERROR, "密码长度不合法");
        }
        // 注册用户
        userMapper.insertUser(new User(){
            {
                setEmail(email);
                setUsername(username);
                setPassword(password);
            }
        });
        return userMapper.selectUserByEmail(email).getId();
    }

    /**
     * 获取当前登录用户
     * @param request 请求
     * @return 用户
     */
    @Override
    public User getLoginUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATUS);
        if (user == null || user.getId() == null) {
            throw new RequestException(ResponseCode.NOT_LOGIN, "查询失败，未登录");
        }
        User userById = this.userMapper.selectUserById(user.getId());
        if (userById == null) {
            throw new RequestException(ResponseCode.NOT_LOGIN, "查询失败，未登录");
        }
        return userById;
    }

    /**
     * 退出登录
     * @param request 请求
     * @return 退出登录结果
     */
    @Override
    public boolean logout(HttpServletRequest request) {
        if (request.getSession().getAttribute(USER_LOGIN_STATUS) == null) {
            throw new RequestException(ResponseCode.OPERATION_ERROR, "操作失败，未登录");
        }
        request.getSession().removeAttribute(USER_LOGIN_STATUS);
        return true;
    }
}
