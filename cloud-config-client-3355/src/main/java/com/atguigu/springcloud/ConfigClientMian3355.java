package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author llp
 * @date 2020/7/8 10:30
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMian3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMian3355.class, args);
    }
}
