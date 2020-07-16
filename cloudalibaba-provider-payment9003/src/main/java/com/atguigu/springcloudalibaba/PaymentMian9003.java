package com.atguigu.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author llp
 * @date 2020/7/16 11:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMian9003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMian9003.class, args);
    }

}
