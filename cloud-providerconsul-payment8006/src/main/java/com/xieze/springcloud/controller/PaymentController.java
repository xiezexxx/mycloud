package com.xieze.springcloud.controller;

import com.xieze.springcloud.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2020/12/19 11:36
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/payment/consul")
    public Response<Integer> getPort(){
        log.info("port：" + port);
        return Response.success(port);
    }
}
