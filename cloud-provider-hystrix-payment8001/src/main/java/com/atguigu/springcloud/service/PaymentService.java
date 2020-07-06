package com.atguigu.springcloud.service;

/**
 * @author llp
 * @date 2020/7/3 14:43
 */
public interface PaymentService {
    String paymentInfo_ok(Integer id);

    String paymentInfo_timeOut(Integer id);

    String paymentCircuitBreaker(Integer id);
}
