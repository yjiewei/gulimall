package com.yangjiewei.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1.引入mybatis plus依赖
 * 2.加入配置
 *   数据源、数据库驱动
 *   mybatis plus配置（包扫描）
 *   映射文件说明
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.yangjiewei.gulimall.product.dao")
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
