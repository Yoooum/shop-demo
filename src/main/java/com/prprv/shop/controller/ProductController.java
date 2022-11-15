package com.prprv.shop.controller;

import com.prprv.shop.common.ResponseCode;
import com.prprv.shop.common.ResultUtil;
import com.prprv.shop.common.SendResponse;
import com.prprv.shop.model.entity.Product;
import com.prprv.shop.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/all")
    public SendResponse<List<Product>> getAllProduct() {
        return ResultUtil.success(productService.selectAll());
    }
}
