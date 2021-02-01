package com.xieze.springcloud.controller;

import com.xieze.springcloud.entity.Response;
import com.xieze.springcloud.service.IStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 16:19
 */
@RestController
public class StorageController {

    private final IStorageService storageService;

    public StorageController(IStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/storage/decrease")
    public Response<Boolean> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId, count);
        return Response.success(Boolean.TRUE);
    }
}
