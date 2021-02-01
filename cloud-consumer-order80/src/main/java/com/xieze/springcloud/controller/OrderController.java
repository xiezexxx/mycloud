package com.xieze.springcloud.controller;

import com.xieze.springcloud.entity.Payment;
import com.xieze.springcloud.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/7 11:19
 */
@RestController
@Slf4j
public class OrderController {

    private final RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://cloud-payment-service";

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/consumer/payment/add")
    public Response<Integer> create(@RequestParam("orderNo") String orderNo){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("orderNo", orderNo);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", map, Response.class);
    }

    @GetMapping("/consumer/payment/info/{id}")
    public Response<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/info/" + id, Response.class);
    }
}
