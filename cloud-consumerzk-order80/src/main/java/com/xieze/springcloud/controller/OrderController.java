package com.xieze.springcloud.controller;

import com.xieze.springcloud.entity.Response;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
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
    private final CuratorFramework curatorFramework;

    private static final String PAYMENT_URL = "http://cloud-payment-service";


    public OrderController(RestTemplate restTemplate, CuratorFramework curatorFramework) {
        this.restTemplate = restTemplate;
        this.curatorFramework = curatorFramework;
    }

    @GetMapping("/consumer/payment/zk")
    public Response<Integer> paymentZk() throws Exception {
        System.out.println(Thread.currentThread().getName() + "进来了");
        InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, "/test");
        try {
            interProcessMutex.acquire();
            System.out.println(Thread.currentThread().getName() + "加锁成功");
            Thread.sleep(30000L);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            interProcessMutex.release();
            System.out.println(Thread.currentThread().getName() + "解锁成功");
        }


        return restTemplate.getForObject(PAYMENT_URL + "/payment/zk", Response.class);
    }
}
