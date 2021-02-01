package com.xieze.springcloud.feign;

import com.xieze.springcloud.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 15:38
 */
@FeignClient(value = "seata-storage-service")
public interface IStorageService{

    @PostMapping(value = "/storage/decrease")
    Response<Boolean> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
