package com.prprv.shop.service.impl;

import com.prprv.shop.model.dto.OrderDTO;
import com.prprv.shop.model.entity.Order;
import com.prprv.shop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 未確認の庭師
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public long insert(OrderDTO orderDTO) {
        return 0;
    }

    @Override
    public long update(long id, OrderDTO orderDTO) {
        return 0;
    }

    @Override
    public long delete(long id) {
        return 0;
    }

    @Override
    public Order select(long id) {
        return null;
    }

    @Override
    public List<Order> selectAll() {
        return null;
    }
}
