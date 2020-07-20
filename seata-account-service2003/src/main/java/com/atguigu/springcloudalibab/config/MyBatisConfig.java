package com.atguigu.springcloudalibab.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author llp
 * @date 2020/7/20 14:31
 */
@Configuration
@MapperScan({"com.atguigu.springcloudalibab.dao"})
public class MyBatisConfig {


}
