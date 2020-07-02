package com.atguitu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author llp
 * @date 2020/7/2 10:51
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String ServerPort;

    @RequestMapping("/payment/consul")
    public String paymentZk() {
        return "Spring cloud with Consul" + ServerPort + UUID.randomUUID().toString();
    }
}
