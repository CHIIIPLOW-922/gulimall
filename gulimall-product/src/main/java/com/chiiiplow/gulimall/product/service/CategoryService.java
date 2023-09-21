package com.chiiiplow.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.product.entity.CategoryEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:27
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

