package com.xieze.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/28 9:49
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class HystrixPayment8001Main {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001Main.class,args);
    }
}
