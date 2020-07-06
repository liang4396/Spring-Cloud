package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author llp
 * @date 2020/7/6 14:54
 */
@Component
public class PaymentServiceFallback implements PaymentService{
    @Override
    public String paymenInfo_ok(Integer id) {
        return "PaymentServiceFallback_paymenInfo_ok o(╥﹏╥)o失败了，请重试！";
    }

    @Override
    public String paymenInfo_timeOut(Integer id) {
        return "PaymentServiceFallback_paymenInfo_timeOut o(╥﹏╥)o失败了，请重试！";
    }
}
