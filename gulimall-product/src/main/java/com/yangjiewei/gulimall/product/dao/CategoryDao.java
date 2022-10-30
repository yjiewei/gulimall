package com.yangjiewei.gulimall.product.dao;

import com.yangjiewei.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 13:10:17
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
