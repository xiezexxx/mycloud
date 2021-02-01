package com.xieze.springcloud.service.impl;

import com.xieze.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/1/20 15:23
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    private MessageChannel output;

    public MessageProviderImpl(MessageChannel output) {
        this.output = output;
    }

    @Override
    public String send() {

        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println(serial);
        return null;
    }
}
