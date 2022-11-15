package com.prprv.shop.service.impl;

import com.prprv.shop.common.ResponseCode;
import com.prprv.shop.exception.RequestException;
import com.prprv.shop.mapper.ProductMapper;
import com.prprv.shop.model.dto.ProductInsertDTO;
import com.prprv.shop.model.entity.Product;
import com.prprv.shop.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 未確認の庭師
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private Product product;
    @Resource
    private ProductMapper productMapper;
    @Override
    public long insert(ProductInsertDTO productInsertDTO) {
        BeanUtils.copyProperties(productInsertDTO, product);
        int result = productMapper.insertProduct(product);
        if (result != 1) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"添加商品失败");
        }
        return product.getId();
    }

    @Override
    public long update() {
        return 0;
    }

    @Override
    public long delete() {
        return 0;
    }

    @Override
    public Product select() {
        return null;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> products = productMapper.selectAllProduct();
        if (products == null) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"查询商品失败");
        }
        return products;
    }
}
