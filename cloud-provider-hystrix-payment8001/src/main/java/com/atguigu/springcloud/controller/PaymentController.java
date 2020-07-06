package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/3 14:48
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymenInfo_ok(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_ok(id);
        log.info("*********result"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymenInfo_timeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_timeOut(id);
        log.info("*********result"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymenInfo_circuit(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*********result"+result);
        return result;
    }
}
