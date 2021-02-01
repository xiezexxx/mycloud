package com.xieze.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/28 15:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GateWay9527 {

    public static void main(String[] args) {
        SpringApplication.run(GateWay9527.class, args);
    }
}
