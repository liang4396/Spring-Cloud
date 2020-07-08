package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author llp
 * @date 2020/6/29 17:21
 */
@RestController
@Slf4j
public class PatmentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    public DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("**************" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功！serverPorr:" + serverPort, result);
        } else {
            return new CommonResult(500, "插入数据失败！", null);
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("**************" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询数据成功！serverPort:" + serverPort, paymentById);
        } else {
            return new CommonResult(500, "查询数据失败，没有对应数据id为" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info("*************" + s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : instances) {
            log.info("getServiceId:" + serviceInstance.getServiceId() + "getHost:" + serviceInstance.getHost() + "getPort:"
                    + serviceInstance.getPort() + "getUri:" + serviceInstance.getUri());
        }
        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentlb() {
        return serverPort;
    }

    @GetMapping("/payment/timeout")
    public String getPaymentTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;

    }
}
