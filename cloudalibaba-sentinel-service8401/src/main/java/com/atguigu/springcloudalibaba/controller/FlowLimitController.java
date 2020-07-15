package com.atguigu.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author llp
 * @date 2020/7/14 15:36
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        int age = 10 / 0;
        return "------testE";
    }

    @GetMapping("/test_toHotKey")
    @SentinelResource(value = "test_toHotKey", blockHandler = "deal_test_toHotKey")
    public String test_toHotKey(@RequestParam(value = "p1", required = false) String p1,
                                @RequestParam(value = "p2", required = false) String p2) {
        return "____________test_toHotKey";
    }

    public String deal_test_toHotKey(String p1, String p2, BlockException e) {
        return "--------------deal_test_toHotKey,o(╥﹏╥)o";
    }
}
