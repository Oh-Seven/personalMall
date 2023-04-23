package com.personal.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.personal.member.fegin.CouponFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.member.entity.UmsMemberEntity;
import com.personal.member.service.UmsMemberService;
import com.personal.common.utils.PageUtils;
import com.personal.common.utils.R;



/**
 * 会员
 *
 * @author lee
 * @email 
 * @date 2023-04-21 14:01:29
 */
@RestController
@RequestMapping("member/umsmember")
@RefreshScope
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @Autowired
    private CouponFegin couponFegin;

    @Value("${member.name}")
    private String name;
    @Value("${member.age}")
    private Integer age;
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:umsmember:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:umsmember:info")
    public R info(@PathVariable("id") Long id){
		UmsMemberEntity umsMember = umsMemberService.getById(id);

        return R.ok().put("umsMember", umsMember);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:umsmember:save")
    public R save(@RequestBody UmsMemberEntity umsMember){
		umsMemberService.save(umsMember);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:umsmember:update")
    public R update(@RequestBody UmsMemberEntity umsMember){
		umsMemberService.updateById(umsMember);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:umsmember:delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/memberCoupon")
    public R memberCoupon(){
        UmsMemberEntity umsMemberEntity = new UmsMemberEntity();
        umsMemberEntity.setUsername("lee");

        R r = couponFegin.memeberCoupon();
        return R.ok().put("memberCoupon", r.get("memberCoupon")).put("member",umsMemberEntity);
    }

    @RequestMapping("/nacosConfig")
    public R nacosConfig(){
        return R.ok().put("name", name).put("age",age);
    }

}
