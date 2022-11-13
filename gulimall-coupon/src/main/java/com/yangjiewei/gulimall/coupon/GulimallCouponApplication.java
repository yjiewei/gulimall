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
 *
 * 配置中心
 *   1.引入配置中心依赖
 *   2.创建一个bootstrap.properties包含应用名和nacos地址
 *   3.给配置中心添加默认添加数据集：应用名.properties
 *   4.给数据集添加配置
 *   5.动态获取配置 @RefreshScope @Value("${coupon.user.name}")
 *   6.优先使用配置中心的值
 *   7.命名空间：配置隔离
 *      - 默认是public，可以用在生产、开发、测试环境不同配置，在不同的命名空间下，可在配置文件下配置
 *      - 也可以用命名空间区分不同的微服务，会去加载命名空间下的全部配置文件，后续可以通过配置集的id和分组进行区分环境
 *   8.配置集、配置集ID、配置分组
 *      - 分组也可以作为开发、测试环境等区分
 *
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
