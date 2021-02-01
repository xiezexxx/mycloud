package com.xieze.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/1/14 13:57
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigMain3344.class, args);
    }
}
