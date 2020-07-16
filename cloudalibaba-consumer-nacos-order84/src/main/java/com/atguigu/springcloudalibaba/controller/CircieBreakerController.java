package com.atguigu.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloudalibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/16 14:39
 */
@RestController
@Slf4j
public class CircieBreakerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String Payment_url;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")
    // @SentinelResource(value = "fallback", fallback = "handlerFallback")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(Payment_url + "/payment/" + id, CommonResult.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgument ,非法参数异常...");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }

        return result;
    }

    public CommonResult handlerFallback(Long id, Throwable throwable) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(500, "服务出现异常！" + throwable.getMessage(), payment);
    }

    public CommonResult blockHandler(@PathVariable Long id, BlockException e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "blockHandler-sentinel 限流，BlockException： " + e.getMessage(), payment);
    }

    @Resource
    PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/{id}")
    @SentinelResource(value = "payment", blockHandler = "blockHandler")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.getPaymentByid(id);
    }
}

