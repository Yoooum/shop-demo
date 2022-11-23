package com.prprv.shop.service;

import com.prprv.shop.model.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 未確認の庭師
 */
public interface UserService {
    /**
     * 用户登录
     * @param email 用户账号
     * @param password 用户密码
     * @param request 请求
     * @return 用户信息
     */
    User login(String email, String password, HttpServletRequest request);

    /**
     * 用户注册
     * @param email 用户账号
     * @param username 用户名
     * @param password 用户密码
     * @return 新用户ID
     */
    long register(String email, String username,String password);

    /**
     * 获取当前登录用户信息
     * @param request 请求
     * @return 用户信息
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 用户登出
     * @param request 请求
     * @return 是否登出成功
     */
    boolean logout(HttpServletRequest request);

    boolean verifyID(Long id, String code);
}
