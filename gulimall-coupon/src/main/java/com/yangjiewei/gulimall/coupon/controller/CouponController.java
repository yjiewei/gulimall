package com.yangjiewei.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.yangjiewei.gulimall.coupon.feign.MemberFeignService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yangjiewei.gulimall.coupon.entity.CouponEntity;
import com.yangjiewei.gulimall.coupon.service.CouponService;
import com.yangjiewei.common.utils.PageUtils;
import com.yangjiewei.common.utils.R;

import javax.annotation.Resource;



/**
 * 优惠券信息
 *
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 17:07:36
 */
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Resource
    private CouponService couponService;

    @Resource
    private MemberFeignService memberFeignService;

    @RequestMapping("/test/feign")
    public R testFeign() {
        System.out.println("测试调用member远程服务");
        return memberFeignService.testMemberFeign();
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
