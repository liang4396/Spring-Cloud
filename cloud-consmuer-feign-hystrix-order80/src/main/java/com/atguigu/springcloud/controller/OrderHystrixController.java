package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/3 15:56
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_info_Golbal_fallbackMethod",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
})
public class OrderHystrixController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymenInfo_ok(@PathVariable("id") Integer id) {
        return paymentService.paymenInfo_ok(id);
    }


    @GetMapping("/consumer/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "payment_info_fallbackMenthod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    public String paymenInfo_timeOut(@PathVariable("id") Integer id) {
        return paymentService.paymenInfo_timeOut(id);
    }

    public String payment_info_fallbackMenthod(@PathVariable("id") Integer id) {
        return "我是消费者80-paymentInfo_timeOut id :" + id + "o(╥﹏╥)o调用失败了！";
    }

    /**
     * 全局服务降级方法
     *
     * @return
     */
    public String payment_info_Golbal_fallbackMethod() {
        return "全局异常处理信息，请稍后再试！";
    }
}
