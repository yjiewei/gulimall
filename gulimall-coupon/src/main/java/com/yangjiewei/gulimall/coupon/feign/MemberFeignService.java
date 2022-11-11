package com.yangjiewei.gulimall.coupon.feign;

import com.yangjiewei.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "gulimall-member")
public interface MemberFeignService {

    @RequestMapping("/member/member/test/feign")
    R testMemberFeign();

}
