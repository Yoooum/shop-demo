package com.prprv.shop.service;

import com.prprv.shop.model.dto.ProductInsertDTO;
import com.prprv.shop.model.entity.Product;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public interface ProductService {
    long insert(ProductInsertDTO productInsertDTO);
    long update();
    long delete();
    Product select();
    List<Product> selectAll();
}
