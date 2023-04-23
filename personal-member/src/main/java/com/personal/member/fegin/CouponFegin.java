package com.personal.member.fegin;

import com.personal.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CouponFegin
 * @author lee
 * @version 1.0
 * @description TODO
 * @date 2023年04月23日 13:16:00
 */
@FeignClient("com.personal.coupon")
public interface CouponFegin {
    @RequestMapping("/coupon/smscoupon/memeber/coupon")
    public R memeberCoupon();
}
