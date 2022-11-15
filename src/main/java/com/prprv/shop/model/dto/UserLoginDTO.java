package com.prprv.shop.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 未確認の庭師
 */
@Data
public class UserLoginDTO implements Serializable {
    private String email;
    private String password;
}
