package com.prprv.shop.model.dto;

import lombok.Data;

/**
 * @author 未確認の庭師
 */
@Data
public class UserRegisterRequest {
    private String email;
    private String username;
    private String password;
}
