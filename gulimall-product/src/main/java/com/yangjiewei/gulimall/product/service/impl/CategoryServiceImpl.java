package com.yangjiewei.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangjiewei.common.utils.PageUtils;
import com.yangjiewei.common.utils.Query;

import com.yangjiewei.gulimall.product.dao.CategoryDao;
import com.yangjiewei.gulimall.product.entity.CategoryEntity;
import com.yangjiewei.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1.查出所有分类
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        // 2.组装成树形结构
        // 找到一级分类、再设置子分类
        List<CategoryEntity> levelMenus = categoryEntities.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(menu -> {
                    menu.setChildren(getChildrens(menu, categoryEntities));
                    return menu;
                }).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
        return levelMenus;
    }

    /**
     * 根据ID删除菜单
     * @param idList
     */
    @Override
    public void removeMenuByIds(List<Long> idList) {
        baseMapper.deleteBatchIds(idList);
    }

    /**
     * 递归查询所有菜单的子菜单
     * @param root 当前菜单
     * @param categoryEntities 所有菜单
     * @return 返回当前菜单的子级菜单
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> categoryEntities) {
        return categoryEntities.stream().filter(categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId()))
                .map(categoryEntity -> {
                    // 继续递归找当前每个菜单的子级菜单
                    categoryEntity.setChildren(getChildrens(categoryEntity, categoryEntities));
                    return categoryEntity;
                }).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
    }

}
