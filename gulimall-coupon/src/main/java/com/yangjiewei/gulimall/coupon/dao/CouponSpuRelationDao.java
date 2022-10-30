package com.yangjiewei.gulimall.coupon.dao;

import com.yangjiewei.gulimall.coupon.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 17:07:36
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
