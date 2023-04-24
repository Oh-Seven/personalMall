package com.personal.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.personal.common.utils.PageUtils;
import com.personal.common.utils.Query;

import com.personal.product.dao.PmsCategoryDao;
import com.personal.product.entity.PmsCategoryEntity;
import com.personal.product.service.PmsCategoryService;


@Service("pmsCategoryService")
public class PmsCategoryServiceImpl extends ServiceImpl<PmsCategoryDao, PmsCategoryEntity> implements PmsCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsCategoryEntity> page = this.page(
                new Query<PmsCategoryEntity>().getPage(params),
                new QueryWrapper<PmsCategoryEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<PmsCategoryEntity> listWithTree() {
        List<PmsCategoryEntity> pmsCategoryEntities = baseMapper.selectList(null);
        List<PmsCategoryEntity> treeData = pmsCategoryEntities.stream()
                .filter(category -> category.getCatLevel() == 1)
                .map(category->{
                    category.setChildren(getChildren(category,pmsCategoryEntities));
                    return category;
                })
                .sorted(Comparator.comparing(PmsCategoryEntity::getSort,Comparator.nullsFirst(Comparator.naturalOrder())))
                .collect(Collectors.toList());
        return treeData;
    }

    /**getChildren
     * @description getTree
     * @author lee
     * @param: Category
     * @param: AllCategory
     * @date 2023/4/24 13:08 
     * @return: java.util.List<com.personal.product.entity.PmsCategoryEntity>
     * @version 1.0
     */
    private List<PmsCategoryEntity> getChildren(PmsCategoryEntity category,List<PmsCategoryEntity> allCategory){
        List<PmsCategoryEntity> treeData = allCategory.stream()
                .filter(e -> e.getParentCid() == category.getCatId())
                .map(e -> {
                    e.setChildren(getChildren(e, allCategory));
                    return e;
                })
                .sorted(Comparator.comparing(PmsCategoryEntity::getSort,Comparator.nullsFirst(Comparator.naturalOrder())))
                .collect(Collectors.toList());
        return treeData;
    }

}