package com.chiiiplow.gulimall.member.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chiiiplow.gulimall.member.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:06:39
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
