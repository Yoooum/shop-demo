package com.prprv.shop.model.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 支付信息表
 */
@Data
public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private long userId;
    private long orderNo;
    private Integer platform;
    private String platformNumber;
    private String platformStatus;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;
}
