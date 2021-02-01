package com.xieze.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 16:18
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动创建的配置
@MapperScan({"com.xieze.springcloud.dao"})
public class SeataStorageMainApp2002 {

    public static void main(String[] args)
    {
        SpringApplication.run(SeataStorageMainApp2002.class, args);
    }
}
