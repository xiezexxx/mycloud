package com.xieze.springcloud.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/1/21 16:36
 */
@RestController
@RefreshScope
public class OrderNacosController implements ApplicationContextAware {

    private RestTemplate restTemplate;
    private ApplicationContext applicationContext;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @Value("1")
    private String userName;

    @Value("1")
    private String userAge;

    public OrderNacosController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id)
    {
        System.err.println("user name :"+userName+"; age: "+userAge);
        return restTemplate.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/consumer/testB")
    public String testB() {
        String forObject = restTemplate.getForObject(serverURL + "/testB", String.class);
        System.out.println(forObject);
        return forObject;
    }
}
