package com.personal.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.order.entity.OrderEntity;
import com.personal.common.utils.PageUtils;

import java.util.Map;

/**
 * 订单
 *
 * @author lee
 * @email 
 * @date 2023-04-21 13:40:00
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

