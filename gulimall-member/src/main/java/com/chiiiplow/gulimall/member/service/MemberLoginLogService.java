package com.chiiiplow.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.member.entity.MemberLoginLogEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * 会员登录记录
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:06:39
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

