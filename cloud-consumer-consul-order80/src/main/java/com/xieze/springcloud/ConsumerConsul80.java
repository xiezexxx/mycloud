package com.xieze.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/19 13:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsul80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsul80.class, args);
    }
}
