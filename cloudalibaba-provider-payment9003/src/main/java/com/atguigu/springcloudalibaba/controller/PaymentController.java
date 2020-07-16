package com.atguigu.springcloudalibaba.controller;

/**
 * @author llp
 * @date 2020/7/16 11:35
 */

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloudalibaba.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById != null) {
            return new CommonResult(200, "serverPort from: "+serverPort+"查询数据成功！", paymentById);
        } else {
            return new CommonResult(404, "serverPort from: "+serverPort+"不存在该数据！");
        }

    }
}
