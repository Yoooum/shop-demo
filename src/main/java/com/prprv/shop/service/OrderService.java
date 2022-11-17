package com.prprv.shop.service;

import com.prprv.shop.model.dto.OrderDTO;
import com.prprv.shop.model.entity.Order;

import java.util.List;

/**
 * @author 未確認の庭師
 */
public interface OrderService {
    long insert(OrderDTO orderDTO);
    long update(long id, OrderDTO orderDTO);
    long delete(long id);
    Order select(long id);
    List<Order> selectAll();
}
