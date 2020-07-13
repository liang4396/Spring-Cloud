package com.atguigu.springcloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/13 14:14
 */
@RestController
@Slf4j
public class NacosController {
    @Resource
    RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

        @GetMapping("/consumer/payment/{id}")
    private String paymentInfo(@PathVariable("id") Integer id) {
        String result = restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
        return result;
    }
}
