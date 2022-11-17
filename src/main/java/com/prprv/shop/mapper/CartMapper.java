package com.prprv.shop.mapper;

import com.prprv.shop.model.entity.Cart;
import com.prprv.shop.model.vo.CartVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 未確認の庭師
 */
@Repository
public interface CartMapper {
    long insertCart(Cart cart);
    long updateCartById(Cart cart);
    long deleteCartByUserId(long id);
    long removeItemByProductId(long id);
    List<CartVO> selectCartByUserId(long id);
    List<Cart> selectAllCart();
}
