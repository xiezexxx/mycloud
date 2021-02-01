package com.xieze.springcloud.service.impl;

import com.xieze.springcloud.dao.IOrderDao;
import com.xieze.springcloud.entity.Order;
import com.xieze.springcloud.feign.IAccountService;
import com.xieze.springcloud.feign.IStorageService;
import com.xieze.springcloud.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 14:50
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderDao orderDao;
    private final IStorageService storageService;
    private final IAccountService accountService;

    public OrderServiceImpl(IOrderDao orderDao, IStorageService storageService, IAccountService accountService) {
        this.orderDao = orderDao;
        this.storageService = storageService;
        this.accountService = accountService;
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void create(Order order) {
        //下单
        orderDao.create(order);
        System.out.println("下单成功");
        //减库存
        storageService.decrease(order.getProductId(), order.getCount());
        System.out.println("减库存成功");
        //修改账户
        accountService.decrease(order.getUserId(), order.getMoney());
        System.out.println("修改账户成功");
        //修改状态
        orderDao.update(order.getUserId(), 0);
        System.out.println("修改状态成功");
    }
}
