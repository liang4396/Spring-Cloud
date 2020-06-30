package com.atguigu.springcloud.conteoller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/6/29 17:21
 */
@RestController
@Slf4j
public class PatmentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("**************" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功！", result);
        } else {
            return new CommonResult(500, "插入数据失败！", null);
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("**************" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询数据成功！", paymentById);
        }else{
            return new CommonResult(500,"查询数据失败，没有对应数据id为"+id,null);
        }
    }
}
