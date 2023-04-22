package com.personal.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.common.utils.PageUtils;
import com.personal.product.entity.PmsBrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author lee
 * @email 
 * @date 2023-04-21 14:03:59
 */
public interface PmsBrandService extends IService<PmsBrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

