package com.personal.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.common.utils.PageUtils;
import com.personal.product.entity.PmsAttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author lee
 * @email 
 * @date 2023-04-22 12:59:38
 */
public interface PmsAttrService extends IService<PmsAttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

