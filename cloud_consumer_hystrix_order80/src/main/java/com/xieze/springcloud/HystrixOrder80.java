package com.xieze.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/28 10:35
 */
@SpringBootApplication
@EnableHystrix
public class HystrixOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrder80.class, args);
    }
}
