package com.prprv.shop.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * 订单表信息
 */
@Data
public class ShoppingCart {
    private long id;
    private long userId;
    private long productId;
    private Integer quantity;
    private Integer checked;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;
}
