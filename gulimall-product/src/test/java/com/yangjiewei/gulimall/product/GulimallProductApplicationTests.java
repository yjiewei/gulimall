/*
 * @author yangjiewei
 * @date 2022/10/30 13:34
 */
package com.yangjiewei.gulimall.product;

import com.yangjiewei.gulimall.product.entity.BrandEntity;
import com.yangjiewei.gulimall.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GulimallProductApplicationTests {

    @Resource
    BrandService brandService;

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setName("华为 杨杰炜");
//        brandService.save(brandEntity);
//        System.out.println("保存成功");
        brandEntity.setBrandId(1L);
        brandEntity.setName("华为");
        brandService.updateById(brandEntity);
    }
}
