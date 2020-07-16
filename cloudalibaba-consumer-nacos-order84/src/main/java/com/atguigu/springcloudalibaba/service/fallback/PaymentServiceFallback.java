package com.atguigu.springcloudalibaba.service.fallback;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloudalibaba.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author llp
 * @date 2020/7/16 15:28
 */
@Component
public class PaymentServiceFallback implements PaymentService {
    @Override
    public CommonResult getPaymentByid(Long id) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(4444, "服务降级，" +
                "--------------PaymentServiceFallback", payment);
    }
}
