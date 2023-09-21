package com.chiiiplow.gulimall.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chiiiplow.gulimall.member.entity.GrowthChangeHistoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 成长值变化历史记录
 * 
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:06:39
 */
@Mapper
public interface GrowthChangeHistoryDao extends BaseMapper<GrowthChangeHistoryEntity> {
	
}
