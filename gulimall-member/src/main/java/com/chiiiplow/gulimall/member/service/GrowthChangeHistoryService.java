package com.chiiiplow.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.member.entity.GrowthChangeHistoryEntity;
import com.chiiiplow.common.utils.PageUtils;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author chiiiplow
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:06:39
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

