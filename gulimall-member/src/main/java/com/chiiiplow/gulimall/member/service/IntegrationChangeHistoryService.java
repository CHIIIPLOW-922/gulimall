package com.chiiiplow.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chiiiplow.gulimall.member.entity.IntegrationChangeHistoryEntity;
import com.joji.common.utils.PageUtils;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author joji
 * @email q641484973@gmail.com
 * @date 2022-10-13 14:06:39
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

