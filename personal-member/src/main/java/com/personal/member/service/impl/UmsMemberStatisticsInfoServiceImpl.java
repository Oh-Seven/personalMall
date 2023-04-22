package com.personal.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.personal.common.utils.PageUtils;
import com.personal.common.utils.Query;

import com.personal.member.dao.UmsMemberStatisticsInfoDao;
import com.personal.member.entity.UmsMemberStatisticsInfoEntity;
import com.personal.member.service.UmsMemberStatisticsInfoService;


@Service("umsMemberStatisticsInfoService")
public class UmsMemberStatisticsInfoServiceImpl extends ServiceImpl<UmsMemberStatisticsInfoDao, UmsMemberStatisticsInfoEntity> implements UmsMemberStatisticsInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberStatisticsInfoEntity> page = this.page(
                new Query<UmsMemberStatisticsInfoEntity>().getPage(params),
                new QueryWrapper<UmsMemberStatisticsInfoEntity>()
        );

        return new PageUtils(page);
    }

}