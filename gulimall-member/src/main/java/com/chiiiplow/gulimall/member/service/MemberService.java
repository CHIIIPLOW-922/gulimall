package com.chiiiplow.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.member.entity.MemberEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 会员
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:06:39
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

