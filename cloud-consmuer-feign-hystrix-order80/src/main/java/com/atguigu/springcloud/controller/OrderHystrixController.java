package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/3 15:56
 */
@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymenInfo_ok(@PathVariable("id") Integer id) {
        return paymentService.paymenInfo_ok(id);
    }


    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String paymenInfo_timeOut(@PathVariable("id") Integer id) {
        return paymentService.paymenInfo_timeOut(id);
    }
}
