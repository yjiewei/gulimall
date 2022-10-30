package com.yangjiewei.gulimall.order.dao;

import com.yangjiewei.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 11:10:53
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
