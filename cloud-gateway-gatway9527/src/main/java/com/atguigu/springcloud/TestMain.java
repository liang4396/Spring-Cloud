package com.atguigu.springcloud;

import java.time.ZonedDateTime;

/**
 * @author llp
 * @date 2020/7/7 13:33
 */
public class TestMain {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        //2020-07-07T13:34:03.879+08:00[Asia/Shanghai]
    }
}
