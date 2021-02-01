package com.xieze.springcloud.feign;

import com.xieze.springcloud.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 15:46
 */
@FeignClient(value = "seata-account-service")
public interface IAccountService{
    @PostMapping(value = "/account/decrease")
    Response<Boolean> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
