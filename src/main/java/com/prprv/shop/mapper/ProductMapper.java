package com.prprv.shop.mapper;

import com.prprv.shop.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 未確認の庭師
 */
@Repository
public interface ProductMapper {
    int insertProduct(Product product);
    int updateProductById(Product product);
    int updateProductByName(Product product);
    int deleteProductById(Long id);
    int deleteProductByName(String name);
    Product selectProductById(Long id);
    Product selectProductByName(String name);
    List<Product> selectAllProduct();
}
