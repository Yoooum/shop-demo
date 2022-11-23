package com.prprv.shop.controller;

import com.prprv.shop.common.ResultUtil;
import com.prprv.shop.common.SendResponse;
import com.prprv.shop.model.dto.CartDTO;
import com.prprv.shop.model.entity.Cart;
import com.prprv.shop.model.vo.CartVO;
import com.prprv.shop.service.CartService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 未確認の庭師
 */
@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {
    @Resource
    private CartService cartService;

    @GetMapping("/{userId}")
    public SendResponse<List<CartVO>> selectCartByUserId(@PathVariable long userId) {
        List<CartVO> carts = cartService.cartList(userId);
        //carts.forEach(System.out::println);
        return ResultUtil.success(carts);
    }

    @PostMapping ("/update")
    public SendResponse<Long> updateCart(@RequestBody CartDTO cartDTO) {
        System.out.println(cartDTO);
        long cartId = cartService.updateCart(cartDTO);
        return ResultUtil.success(cartId);
    }

    @GetMapping("/new/{userId}/{itemId}")
    public SendResponse<Long> insertCart(@PathVariable long userId, @PathVariable long itemId) {
        System.out.println(userId+" "+itemId);
        long cartId = cartService.addItem(userId, itemId);
        return ResultUtil.success(cartId);
    }
}
