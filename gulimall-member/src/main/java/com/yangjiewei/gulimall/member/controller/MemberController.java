package com.yangjiewei.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yangjiewei.gulimall.member.entity.MemberEntity;
import com.yangjiewei.gulimall.member.service.MemberService;
import com.yangjiewei.common.utils.PageUtils;
import com.yangjiewei.common.utils.R;

import javax.annotation.Resource;



/**
 * 会员
 *
 * @author yangjiewei
 * @email yang_7131@163.com
 * @date 2022-10-30 17:15:29
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @RequestMapping("/test/feign")
    public R testMemberFeign(){
        System.out.println("测试feign服务远程调用");
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(1L);
        memberEntity.setNickname("杨杰炜");
        return R.ok().put("test", memberEntity);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
