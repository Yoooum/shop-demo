package com.prprv.shop.service;

import com.prprv.shop.model.dto.ProductInsertDTO;
import com.prprv.shop.model.dto.ProductDTO;
import com.prprv.shop.model.entity.Product;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public interface ProductService {
    long insert(ProductDTO productDTO);
    long update(long id, ProductDTO productDTO);
    long delete(long id);
    Product select(long id);
    List<Product> selectAll();
}
