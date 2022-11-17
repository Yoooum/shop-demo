package com.prprv.shop.controller;

import com.prprv.shop.common.ResponseCode;
import com.prprv.shop.common.ResultUtil;
import com.prprv.shop.common.SendResponse;
import com.prprv.shop.exception.RequestException;
import com.prprv.shop.model.dto.ProductDTO;
import com.prprv.shop.model.dto.ProductInsertDTO;
import com.prprv.shop.model.entity.Product;
import com.prprv.shop.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 未確認の庭師
 */
@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Resource
    private ProductService productService;

    @PostMapping("/insert")
    public SendResponse<Long> insert(ProductDTO productDTO) {
        long productId = productService.insert(productDTO);
        if (productId == 0) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"添加商品失败");
        }
        return ResultUtil.success(productId);
    }

    @PostMapping("/update/{id}")
    public SendResponse<Long> update(@PathVariable long id, ProductDTO productDTO) {
        long productId = productService.update(id,productDTO);
        if (productId == 0) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"更新商品失败");
        }
        return ResultUtil.success(productId);
    }

    @GetMapping("/delete/{id}")
    public SendResponse<Long> delete(@PathVariable long id) {
        long productId = productService.delete(id);
        if (productId == 0) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"删除商品失败");
        }
        return ResultUtil.success(productId);
    }

    @GetMapping("/select/{id}")
    public SendResponse<Product> select(@PathVariable long id) {
        Product product = productService.select(id);
        if (product == null) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"查询商品失败");
        }
        return ResultUtil.success(product);
    }

    @GetMapping("/all")
    public SendResponse<List<Product>> getAllProduct() {
        return ResultUtil.success(productService.selectAll());
    }
}
