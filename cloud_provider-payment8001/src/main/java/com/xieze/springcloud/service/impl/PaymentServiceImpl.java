package com.xieze.springcloud.service.impl;

import com.xieze.springcloud.entity.Payment;
import com.xieze.springcloud.repository.PaymentMapper;
import com.xieze.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/3 18:17
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
