package com.prprv.shop.mapper;

import com.prprv.shop.model.entity.Cart;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 未確認の庭師
 */
@SpringBootTest
class CartMapperTest{

    @Resource
    private Cart Cart;
    @Resource
    private CartMapper CartMapper;

    @Test
    void insertCart() {
        Cart.setUserId(10L);
        Cart.setProductId(3L);
        Cart.setQuantity(10);
        Cart.setChecked(1);
        long cart = CartMapper.insertCart(Cart);
        System.out.println(cart);
    }

    @Test
    void updateCartById() {
        Cart.setUserId(13L);
        Cart.setProductId(1L);
        Cart.setQuantity(10);
        Cart.setChecked(1);
        Cart.setIsDeleted(0);
        long cart = CartMapper.updateCartById(Cart);
        System.out.println(cart);
    }

    // 根据用户id清空购物车
    @Test
    void deleteCartByUserId() {
        long cart = CartMapper.deleteCartByUserId(12);
        System.out.println(cart);
    }

    // 根据用户id查询购物车
    @Test
    void selectCartByUserId() {
        CartMapper.selectCartByUserId(13).forEach(System.out::println);
    }

    // 查询所有购物车
    @Test
    void selectAllCart() {
        CartMapper.selectAllCart().forEach(System.out::println);
    }
}