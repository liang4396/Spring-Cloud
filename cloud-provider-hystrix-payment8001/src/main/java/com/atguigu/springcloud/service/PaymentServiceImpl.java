package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author llp
 * @date 2020/7/3 14:44
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_ok id :" + id + "^_^";
    }

    @Override
    @HystrixCommand(fallbackMethod = "payment_info_fallbackMenthod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_timeOut(Integer id) {
        int timeOut = 3;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "8001-paymentInfo_timeOut id :" + id + "^_^ 耗时" + timeOut;
    }

    public String payment_info_fallbackMenthod(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "8001-paymentInfo_timeOut id :" + id + "o(╥﹏╥)o调用失败了！";
    }

    /*
     * 服务熔断！
     * */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),              //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),    //请求数达到后才计算
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  //错误率达到多少跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return "线程池:" + Thread.currentThread().getName() + "版本流水号 :" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id不能为负数，请稍后再试 id:" + id;
    }
}
