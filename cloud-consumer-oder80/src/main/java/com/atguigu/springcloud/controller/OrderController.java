package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author llp
 * @date 2020/6/30 13:56
 */
@RestController
@Slf4j
public class OrderController {
    //private static final String PAYMENT_URL = "http://localhost:8081/";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    public DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL + "payment/create", payment, CommonResult.class);
        return commonResult;
    }

    @PostMapping("/consumer/payment2/create")
    public CommonResult<Payment> create2(Payment payment) {
                /*
        getForEntity 可以获取更详细的信息 比如Header信息、响应体、状态码 返回的结果更像一个实体信息
        而getForObject方法直接返回为json字符串 结果和 getForEntity结果的getBoyd()结果一致
        只是结果更详细
        * */
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "payment/create", payment, CommonResult.class);
        if (commonResultResponseEntity.getStatusCode().is2xxSuccessful()) {
            return commonResultResponseEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult forObject = restTemplate.getForObject(PAYMENT_URL + "payment/" + id, CommonResult.class);
        return forObject;
    }

    @GetMapping("/consumer/payment/get2/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id) {
        /*
        getForEntity 可以获取更详细的信息 比如Header信息、响应体、状态码 返回的结果更像一个实体信息
        而getForObject方法直接返回为json字符串 结果和 getForEntity结果的getBoyd()结果一致
        只是结果更详细
        * */
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "payment/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }


    @GetMapping("/payment/lb")
    public String getPaymentlb() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() == 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}
