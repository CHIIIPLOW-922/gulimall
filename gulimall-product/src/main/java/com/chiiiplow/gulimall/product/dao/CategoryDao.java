package com.chiiiplow.gulimall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chiiiplow.gulimall.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:27
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
