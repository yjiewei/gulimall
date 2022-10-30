package com.yangjiewei.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangjiewei.common.utils.PageUtils;
import com.yangjiewei.gulimall.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 17:07:36
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

