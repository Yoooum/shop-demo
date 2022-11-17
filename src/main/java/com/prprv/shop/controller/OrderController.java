package com.prprv.shop.controller;

import com.prprv.shop.common.ResultUtil;
import com.prprv.shop.common.SendResponse;
import com.prprv.shop.model.dto.OrderDTO;
import com.prprv.shop.model.entity.Order;
import com.prprv.shop.service.OrderService;
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
@RequestMapping("/api/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @PostMapping("/insert")
    public SendResponse<Long> insert(OrderDTO orderDTO) {
        long insert = orderService.insert(orderDTO);
        return ResultUtil.success(insert);
    }

    @PostMapping("/update/{id}")
    public SendResponse<Long> update(@PathVariable long id, OrderDTO orderDTO) {
        long update = orderService.update(id, orderDTO);
        return ResultUtil.success(update);
    }

    @PostMapping("/delete/{id}")
    public SendResponse<Long> delete(@PathVariable long id) {
        long delete = orderService.delete(id);
        return ResultUtil.success(delete);
    }

    @PostMapping("/select/{id}")
    public SendResponse<Order> select(@PathVariable long id) {
        Order select = orderService.select(id);
        return ResultUtil.success(select);
    }

    @PostMapping("/all")
    public SendResponse<List<Order>> selectAll() {
        List<Order> select = orderService.selectAll();
        return ResultUtil.success(select);
    }
}
