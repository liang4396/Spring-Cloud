package com.atguigu.springcloudalibaba.dao;

import com.atguigu.springcloudalibaba.domian.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author llp
 * @date 2020/7/20 13:07
 */
@Mapper
public interface OrderDao {
    //新建订单
    void createOrder(Order order);

    //修改订单状态从0》1
    void update(@Param("userId") Long userId,@Param("status")Integer status);
}
