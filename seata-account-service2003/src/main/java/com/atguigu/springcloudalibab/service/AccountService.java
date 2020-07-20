package com.atguigu.springcloudalibab.service;

import java.math.BigDecimal;

/**
 * @author llp
 * @date 2020/7/20 14:28
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
