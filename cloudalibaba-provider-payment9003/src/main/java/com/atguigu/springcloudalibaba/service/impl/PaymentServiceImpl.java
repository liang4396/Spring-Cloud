package com.atguigu.springcloudalibaba.service.impl;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloudalibaba.dao.PaymentDao;
import com.atguigu.springcloudalibaba.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/16 11:34
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
