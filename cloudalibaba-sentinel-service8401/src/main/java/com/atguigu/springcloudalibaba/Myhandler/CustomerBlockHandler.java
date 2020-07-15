package com.atguigu.springcloudalibaba.Myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;

/**
 * @author llp
 * @date 2020/7/15 14:45
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(444,
                "按照客户自定义的Global--1号，handleException");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(444,
                "按照客户自定义的Global---2号，handleException");
    }
}
