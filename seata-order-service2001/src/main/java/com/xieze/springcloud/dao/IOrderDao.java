package com.xieze.springcloud.dao;

import com.xieze.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 14:44
 */
@Mapper
public interface IOrderDao {

    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
