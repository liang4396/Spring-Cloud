package com.atguigu.springcloudalibaba.service.impl;

import com.atguigu.springcloudalibaba.dao.OrderDao;
import com.atguigu.springcloudalibaba.domian.Order;
import com.atguigu.springcloudalibaba.service.AccountService;
import com.atguigu.springcloudalibaba.service.OrderService;
import com.atguigu.springcloudalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author llp
 * @date 2020/7/20 13:23
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        orderDao.createOrder(order);
        log.info("开始创建订单！");

        storageService.decrease(order.getProductId(), order.getCount());
        log.info("开始调用库存微服务");

        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("扣除账户金额");

        orderDao.update(order.getUserId(),0);
        log.info("修改订单状态，标记为已完成！");
    }
}
