package com.atguigu.springcloudalibaba.controller;

import com.atguigu.springcloudalibaba.domian.CommonResult;
import com.atguigu.springcloudalibaba.domian.Order;
import com.atguigu.springcloudalibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/20 13:40
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        try {
            orderService.createOrder(order);
            return new CommonResult(200,"订单创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(444,"订单创建异常！"+e.getMessage());
        }
    }
}
