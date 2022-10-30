package com.yangjiewei.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangjiewei.common.utils.PageUtils;
import com.yangjiewei.gulimall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 17:15:29
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

