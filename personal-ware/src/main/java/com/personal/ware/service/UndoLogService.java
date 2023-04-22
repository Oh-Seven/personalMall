package com.personal.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.personal.common.utils.PageUtils;
import com.personal.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author lee
 * @email 
 * @date 2023-04-21 14:06:27
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

