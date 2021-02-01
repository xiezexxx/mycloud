package com.xieze.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 16:13
 */
public interface IStorageService {

    void decrease(Long productId, Integer count);
}
