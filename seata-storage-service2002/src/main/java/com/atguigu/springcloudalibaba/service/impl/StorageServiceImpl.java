package com.atguigu.springcloudalibaba.service.impl;

import com.atguigu.springcloudalibaba.dao.StorageDao;
import com.atguigu.springcloudalibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/20 14:13
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----> storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("----> storage-service中扣减库存结束");
    }
}
