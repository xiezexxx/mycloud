package com.xieze.springcloud.task;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/1/20 16:08
 */

@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerTask {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者一号，接收：" + message.getPayload() + "\t port：" + serverPort);
    }
}
