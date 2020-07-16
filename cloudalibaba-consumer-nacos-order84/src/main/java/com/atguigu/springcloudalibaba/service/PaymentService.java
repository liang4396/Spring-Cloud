package com.atguigu.springcloudalibaba.service;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloudalibaba.service.fallback.PaymentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author llp
 * @date 2020/7/16 15:26
 */
@FeignClient(value = "cloudalibaba-nacos-provider-payment",fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping("/payment/{id}")
    CommonResult getPaymentByid(@PathVariable("id") Long id);
}
