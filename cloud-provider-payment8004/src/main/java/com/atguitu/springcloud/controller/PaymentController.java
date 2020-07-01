package com.atguitu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author llp
 * @date 2020/7/1 16:18
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String ServerPort;

    @RequestMapping("/payment/zk")
    public String paymentZk() {
        return "Strping cloud with Zookeeper" + ServerPort + UUID.randomUUID().toString();
    }
}
