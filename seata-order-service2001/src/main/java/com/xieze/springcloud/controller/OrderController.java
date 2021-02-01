package com.xieze.springcloud.controller;

import com.xieze.springcloud.entity.Order;
import com.xieze.springcloud.entity.Response;
import com.xieze.springcloud.service.IOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 14:58
 */
@RestController
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/create")
    public Response<Boolean> createOrder(Order order){
        //创建订单
        orderService.create(order);
        return Response.success(Boolean.TRUE);
    }
}
