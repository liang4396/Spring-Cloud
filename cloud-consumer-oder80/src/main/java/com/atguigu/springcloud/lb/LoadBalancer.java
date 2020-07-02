package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author llp
 * @date 2020/7/2 15:01
 */
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
