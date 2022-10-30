package com.yangjiewei.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangjiewei.common.utils.PageUtils;
import com.yangjiewei.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 13:10:17
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

