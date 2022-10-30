package com.yangjiewei.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangjiewei.common.utils.PageUtils;
import com.yangjiewei.gulimall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 13:10:16
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

