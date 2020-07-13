package com.atguigui.springcloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author llp
 * @date 2020/7/13 13:50
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String ServerPort;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "hello! Nacos !serverport:" + ServerPort + "========id:" + id;
    }
}
