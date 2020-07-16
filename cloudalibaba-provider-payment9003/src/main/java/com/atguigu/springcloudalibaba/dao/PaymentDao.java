package com.atguigu.springcloudalibaba.dao;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author llp
 * @date 2020/7/16 11:29
 */
@Mapper
public interface PaymentDao {
    Payment getPaymentById(Long id);
}
