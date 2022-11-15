package com.prprv.shop.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单明细表信息
 */
@Data
public class OrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private long orderNo;
    private long userId;
    private long productId;
    private double currentUnitPrice;
    private Integer quantity;
    private double totalPrice;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;
}
