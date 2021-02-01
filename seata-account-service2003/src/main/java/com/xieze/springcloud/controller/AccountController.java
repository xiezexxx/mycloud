package com.xieze.springcloud.controller;

import com.xieze.springcloud.service.IAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.xieze.springcloud.entity.Response;

import java.math.BigDecimal;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 16:36
 */
@RestController
public class AccountController {

    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/account/decrease")
    public Response<Boolean> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);
        return Response.success(Boolean.TRUE);
    }
}
