/*
 * @author yangjiewei
 * @date 2022/11/19 16:19
 */
package com.yangjiewei.gulimall.product.config;

import com.yangjiewei.gulimall.product.annotation.ApiRestController;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiPrefixAutoConfiguration implements WebMvcConfigurer {

    /**
     * <p>
     * 增加restApi前缀
     * </p>
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/renren-fast", c -> c.isAnnotationPresent(ApiRestController.class));
    }

}
