package com.chiiiplow.gulimall.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chiiiplow.common.utils.PageUtils;
import com.chiiiplow.common.utils.Query;
import com.chiiiplow.gulimall.product.dao.CategoryDao;
import com.chiiiplow.gulimall.product.entity.CategoryBrandRelationEntity;
import com.chiiiplow.gulimall.product.entity.CategoryEntity;
import com.chiiiplow.gulimall.product.service.CategoryBrandRelationService;
import com.chiiiplow.gulimall.product.service.CategoryService;
import com.chiiiplow.gulimall.product.vo.Catelog2Vo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Resource
    private CategoryBrandRelationService categoryBrandRelationService;

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

        //1、查询出所有分类
        List<CategoryEntity> entities = super.baseMapper.selectList(null);

        //2、组装成父子的树形结构

        //2.1)、找到所有一级分类
        List<CategoryEntity> levelMenus = entities.stream()
                .filter(e -> e.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildrens(menu,entities));
                    return menu;
                })
                .sorted((menu,menu2) -> {
                    return (menu.getSort() == null ? 0 : menu.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
                })
                .collect(Collectors.toList());

        return levelMenus;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 检查当前删除的菜单，是否被别的地方引用

        //逻辑删除
        baseMapper.deleteBatchIds(asList);
    }


    //递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all) {

        List<CategoryEntity> children = all.stream().filter(categoryEntity ->{
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            //1、找到子菜单(递归)
            categoryEntity.setChildren(getChildrens(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu,menu2) -> {
            //2、菜单的排序
            return (menu.getSort() == null ? 0 : menu.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort());
        }).collect(Collectors.toList());

        return children;

    }

    //[2,29,20]
    @Override
    public Long[] findCatelogPath(Long catelogId) {

        List<Long> paths = new ArrayList<>();

        //递归查询是否还有父节点
        List<Long> parentPath = findParentPath(catelogId, paths);

        //进行一个逆序排列
        Collections.reverse(parentPath);

        return (Long[]) parentPath.toArray(new Long[parentPath.size()]);
    }


    /**
     * 级联更新所有关联的数据
     * @param category
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateCascade(CategoryEntity category) {
        this.baseMapper.updateById(category);

        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());
    }

    @Override
    public List<CategoryEntity> getLevel1Categorys() {
        return null;
    }

    @Override
    public Map<String, List<Catelog2Vo>> getCatalogJson() {
        return null;
    }

    private List<Long> findParentPath(Long catelogId, List<Long> paths) {

        //1、收集当前节点id
        paths.add(catelogId);

        //根据当前分类id查询信息
        CategoryEntity byId = this.getById(catelogId);
        //如果当前不是父分类
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(),paths);
        }

        return paths;
    }


}