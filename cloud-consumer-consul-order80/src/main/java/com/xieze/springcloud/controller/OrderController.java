package com.xieze.springcloud.controller;

import com.xieze.springcloud.entity.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/16 16:42
 */
@RestController
public class OrderController {

    private final RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://cloud-payment-service";


    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/payment/consul")
    public Response<Integer> paymentZk() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", Response.class);
    }
}
