package com.atguigui.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author llp
 * @date 2020/7/13 13:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMian9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMian9001.class, args);
    }
}
