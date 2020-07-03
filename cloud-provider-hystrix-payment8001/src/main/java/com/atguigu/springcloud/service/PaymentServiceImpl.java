package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author llp
 * @date 2020/7/3 14:44
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "线程池:"+ Thread.currentThread().getName()+"paymentInfo_ok id :"+id+"^_^";
    }

    @Override
    public String paymentInfo_timeOut(Integer id) {
        int timeOut = 3;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+ Thread.currentThread().getName()+"paymentInfo_timeOut id :"+id+"^_^ 耗时"+timeOut;
    }
}
