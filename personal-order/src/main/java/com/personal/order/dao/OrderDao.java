package com.personal.order.dao;

import com.personal.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author lee
 * @email 
 * @date 2023-04-21 13:40:00
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
