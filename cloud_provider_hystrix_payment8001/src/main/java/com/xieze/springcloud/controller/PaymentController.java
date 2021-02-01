package com.xieze.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/28 10:14
 */
@RestController
public class PaymentController {

    @GetMapping("payment/ok")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
        }, fallbackMethod = "paymentOkFallback")
    public String paymentOk() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "paymentOk");
        Thread.sleep(4000L);
        return "paymentOk";
    }

    @GetMapping("payment/time/out")
    @HystrixCommand(commandProperties = {

    })
    public String paymentTimeOut(){
        return "paymentTimeOut";
    }

    public String paymentOkFallback(){
        System.out.println(Thread.currentThread().getName() + "paymentOkFallback");
        return "paymentOkFallback";
    }
}
