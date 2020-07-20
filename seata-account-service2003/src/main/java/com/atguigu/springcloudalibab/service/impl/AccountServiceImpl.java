package com.atguigu.springcloudalibab.service.impl;

import com.atguigu.springcloudalibab.dao.AccountDao;
import com.atguigu.springcloudalibab.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author llp
 * @date 2020/7/20 14:29
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("----> account-service中扣减用户余额开始");

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId, money);
        log.info("----> account-service中扣减用户余额开始");
    }
}
