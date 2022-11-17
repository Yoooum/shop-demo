package com.prprv.shop.service.impl;

import com.prprv.shop.common.ResponseCode;
import com.prprv.shop.exception.RequestException;
import com.prprv.shop.mapper.CartMapper;
import com.prprv.shop.model.dto.CartDTO;
import com.prprv.shop.model.entity.Cart;
import com.prprv.shop.model.vo.CartVO;
import com.prprv.shop.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 未確認の庭師
 */
@Slf4j
@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;
    @Resource
    private Cart cart;
    @Override
    public long addItem(long userId, long itemId) {
        cart.setUserId(userId);
        cart.setProductId(itemId);
        cart.setQuantity(1);
        cart.setChecked(1);
        System.out.println(cart);
        long result = cartMapper.insertCart(cart);
        if (result != 1) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"购物车已存在该商品");
        }
        return result;
    }

    @Override
    public long updateCart(CartDTO cartDTO) {
        if (cartDTO.getQuantity() <= 0){
            return cartMapper.removeItemByProductId(cartDTO.getItemId());
        }
        cart.setUserId(cartDTO.getUserId());
        cart.setProductId(cartDTO.getItemId());
        cart.setQuantity(cartDTO.getQuantity());
        cart.setChecked(cartDTO.getChecked());
        cart.setIsDeleted(0);
        long result = cartMapper.updateCartById(cart);
        if (result != 1) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"更新购物车失败");
        }
        return result;
    }

    @Override
    public long clearCart(long userId) {
        long result = cartMapper.deleteCartByUserId(userId);
        if (result != 1) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"清空购物车失败");
        }
        return result;
    }

    @Override
    public void checkout(long userId) {
        cartMapper.selectCartByUserId(userId).forEach(System.out::println);
    }

    @Override
    public List<CartVO> cartList(long userId) {
        List<CartVO> carts = cartMapper.selectCartByUserId(userId);

        if (carts == null) {
            throw new RequestException(ResponseCode.OPERATION_ERROR,"查询购物车失败");
        }
        // 遍历计算价格
        carts.forEach(cart -> cart.setTotalPrice(cart.getPrice() * cart.getQuantity()));
        return carts;
    }
}
