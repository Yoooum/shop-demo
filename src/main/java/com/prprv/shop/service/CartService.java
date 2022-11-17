package com.prprv.shop.service;

import com.prprv.shop.model.dto.CartDTO;
import com.prprv.shop.model.vo.CartVO;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public interface CartService {
    long addItem(long userId, long itemId);
    long updateCart(CartDTO cartDTO);
    long clearCart(long userId);
    void checkout(long userId);
    List<CartVO> cartList(long userId);
}
