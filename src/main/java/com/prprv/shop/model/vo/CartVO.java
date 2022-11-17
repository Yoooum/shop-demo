package com.prprv.shop.model.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 未確認の庭師
 */
@Data
@Component
public class CartVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private long id;
    private long userId;
    private long productId;
    private Integer quantity;
    private Integer checked;
    private String name;
    private String image;
    private double price;
    private double totalPrice;
}
