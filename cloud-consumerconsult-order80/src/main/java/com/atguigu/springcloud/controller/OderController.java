package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/2 11:08
 */
@RestController
@Slf4j
public class OderController {
    private static final String SERVER_URLS = "http://consult-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order/consul")
    public String paymentinfo() {
        String result = restTemplate.getForObject(SERVER_URLS + "/payment/consul", String.class);
        return result;
    }
}
