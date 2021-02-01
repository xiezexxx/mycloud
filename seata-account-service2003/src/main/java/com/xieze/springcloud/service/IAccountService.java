package com.xieze.springcloud.service;

import java.math.BigDecimal;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 16:33
 */
public interface IAccountService {

    void decrease(Long userId, BigDecimal money);

}
