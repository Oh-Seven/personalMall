package com.personal.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.common.utils.PageUtils;
import com.personal.member.entity.UmsMemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author lee
 * @email 
 * @date 2023-04-21 14:01:29
 */
public interface UmsMemberService extends IService<UmsMemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

