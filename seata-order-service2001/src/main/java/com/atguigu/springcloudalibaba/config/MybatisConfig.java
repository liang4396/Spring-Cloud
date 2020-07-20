package com.atguigu.springcloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author llp
 * @date 2020/7/20 13:44
 */
@Configuration
@MapperScan({"com.atguigu.springcloudalibaba.dao"})
public class MybatisConfig {


}
