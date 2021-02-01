package com.xieze.springcloud.service;


import com.xieze.springcloud.entity.Payment;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/3 18:16
 */
public interface IPaymentService {

    int create(Payment payment);


    Payment getPaymentById(Long id);
}
