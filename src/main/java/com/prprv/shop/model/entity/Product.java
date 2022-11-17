package com.prprv.shop.model.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品表信息
 */
@Data
@Component
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private String category;
    private String name;
    private String image;
    private String detail;
    private double price;
    private Integer stock;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;
}
