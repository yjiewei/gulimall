package com.yangjiewei.gulimall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 远程调用
 *   1.引入open-feign依赖 gulimall-common/pom.xml:83
 *   2.编写一个接口，告诉spring cloud这个接口需要调用远程服务 com.yangjiewei.gulimall.coupon.feign.MemberFeignService#testMemberFeign()
 *   3.声明接口的每一个方法都是调用哪个远程服务的那个请求 @FeignClient("gulimall-member")
 *   4.开启远程调用声明 @EnableFeignClients
 */
@EnableFeignClients(basePackages = "com.yangjiewei.gulimall.coupon.feign")
@SpringBootApplication
@MapperScan("com.yangjiewei.gulimall.coupon.dao")
@EnableDiscoveryClient
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
