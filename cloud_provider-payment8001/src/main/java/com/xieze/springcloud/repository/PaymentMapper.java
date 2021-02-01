package com.xieze.springcloud.repository;

import com.xieze.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/3 17:56
 */
@Mapper
public interface PaymentMapper {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
