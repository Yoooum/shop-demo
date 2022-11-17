package com.prprv.shop.mapper;

import com.prprv.shop.model.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 未確認の庭師
 */
@Repository
public interface OrderMapper {
    long insert(Order order);
    long updateOrderById(Order order);
    long deleteOrderById(long id);
    Order selectOrderById(long id);
    List<Order> selectAllOrder();
}
