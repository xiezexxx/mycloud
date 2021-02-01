package com.xieze.springcloud.service.impl;

import com.xieze.springcloud.dao.IAccountDao;
import com.xieze.springcloud.service.IAccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 16:34
 */
@Service
public class AccountServiceImpl implements IAccountService {

    private final IAccountDao accountDao;

    public AccountServiceImpl(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.update(userId, money);
    }
}
