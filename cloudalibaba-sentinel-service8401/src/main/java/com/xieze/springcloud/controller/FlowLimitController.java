package com.xieze.springcloud.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/1/25 16:02
 */
@RestController
public class FlowLimitController {



    @GetMapping("/testB")
    @SentinelResource(value = "testB")
    public String testB() {
        return "------testB";
    }


    public String testHandle(BlockException exception) {
        return "系统繁忙";
    }

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public String byResource(){
        return "限流测试ok";
    }

    public String handleException(BlockException exception){
        return "限流测试handleException" + exception.getMessage();
    }

    public static void main(String[] args) {
        FlowRule flowRule = new FlowRule("testB");
        flowRule.setCount(1);
        System.out.println(JSONUtil.toJsonStr(flowRule));
    }

}
