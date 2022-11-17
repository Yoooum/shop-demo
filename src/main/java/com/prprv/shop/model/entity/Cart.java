package com.prprv.shop.model.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单表信息
 */
@Data
@Component
public class Cart implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private long userId;
    private long productId;
    private Integer quantity;
    private Integer checked;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;
}
