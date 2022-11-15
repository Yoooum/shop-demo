package com.prprv.shop.model.dto;

import lombok.Data;

/**
 * @author 未確認の庭師
 */
@Data
public class ProductInsertDTO {
    private String name;
    private String category;
    private String image;
    private String detail;
    private double price;
    private Integer stock;
    private Integer status;
}
