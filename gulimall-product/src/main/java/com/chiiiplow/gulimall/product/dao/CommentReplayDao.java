package com.chiiiplow.gulimall.product.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chiiiplow.gulimall.product.entity.CommentReplayEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 12:43:26
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
