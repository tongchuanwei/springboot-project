package com.hello.way.project.biz.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by way on 2019/4/8.
 */
@Configuration
@MapperScan({"com.hello.way.project.biz.infrastructure.dao"})
public class MyBatisConfig {
}
