package com.yangjiewei.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangjiewei.common.utils.PageUtils;
import com.yangjiewei.gulimall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 17:07:36
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

