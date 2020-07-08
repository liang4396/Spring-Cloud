package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author llp
 * @date 2020/7/8 11:22
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentConfig8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConfig8004.class, args);
    }

}