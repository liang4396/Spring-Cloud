package com.atguigu.springcloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author llp
 * @date 2020/7/20 14:14
 */
@Configuration
@MapperScan({"com.atguigu.springcloudalibaba.dao"})
public class MyBatisConfig {


}
