package com.xieze.springcloud.controller;

import com.xieze.springcloud.entity.Payment;
import com.xieze.springcloud.entity.Response;
import com.xieze.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/5 17:52
 */
@RestController
@Slf4j
public class PaymentController {

    private final IPaymentService paymentService;

    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment/info/{id}")
    public Response<Payment> getPaymentById(@PathVariable("id") Long id){
        System.out.println("22222242");
        return Response.success(paymentService.getPaymentById(id)).setMd5("8001");
    }

    @PostMapping("/payment/add")
    public Response<Integer> getPaymentById(@RequestParam("orderNo") String orderNo){
        Payment payment = new Payment();
        payment.setOrderNo(orderNo);
        return Response.success(paymentService.create(payment));
    }
}
