package com.xieze.springcloud.controller;

import com.xieze.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/1/20 15:31
 */
@RestController
public class SendController {

    private IMessageProvider messageProvider;

    public SendController(IMessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @GetMapping("/send")
    public void send(){
        messageProvider.send();
    }
}
