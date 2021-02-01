package com.xieze.springcloud.service.impl;

import com.xieze.springcloud.dao.IStorageDao;
import com.xieze.springcloud.service.IStorageService;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * 描述：...
 *
 * @author xieze
 * @date 2021/2/1 16:15
 */
@Service
public class StorageServiceImpl implements IStorageService {

    private final IStorageDao storageDao;

    public StorageServiceImpl(IStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.update(productId, count);
    }
}
