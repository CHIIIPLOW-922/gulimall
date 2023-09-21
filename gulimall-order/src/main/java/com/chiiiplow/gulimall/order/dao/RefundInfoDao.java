package com.chiiiplow.gulimall.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chiiiplow.gulimall.order.entity.RefundInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 * 
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:19:20
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {
	
}
