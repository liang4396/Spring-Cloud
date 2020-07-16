package com.atguigu.springcloudalibaba.service;

import com.atguigu.springcloud.entity.Payment;

/**
 * @author llp
 * @date 2020/7/16 11:34
 */
public interface PaymentService {
    Payment getPaymentById(Long id);
}
