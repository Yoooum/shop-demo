package com.prprv.shop.model.dto;

import lombok.Data;

/**
 * @author 未確認の庭師
 */
@Data
public class CartDTO {
    private long userId;
    private long itemId;
    private int quantity;
    private int checked;
}
