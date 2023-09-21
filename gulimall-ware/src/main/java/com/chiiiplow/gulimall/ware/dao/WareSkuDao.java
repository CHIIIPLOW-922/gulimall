package com.chiiiplow.gulimall.ware.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chiiiplow.gulimall.ware.entity.WareSkuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:23:18
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
